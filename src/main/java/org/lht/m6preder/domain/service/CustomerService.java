package org.lht.m6preder.domain.service;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repo;
  private final PasswordEncoder passwordEncoder;

  public List<Customer> findAll() {
    return repo.findAll();
  }

  public Optional<Customer> findById(Long customerId) {
    return repo.findById(customerId);
  }

  public Customer save(Customer customer) {
    User userOfCustomer = customer.getUser();

    userOfCustomer.setPassword(passwordEncoder.encode(userOfCustomer.getPassword()));

    return repo.save(customer);
  }

  public boolean delete(Long customerId) {
    return findById(customerId)
            .map(cliente -> {
              repo.delete(customerId);
              return true;
            }).orElse(false);
  }

  public Optional<Customer> findByUserId(Long userId) {
    return repo.getByUsuario_IdUsuario(userId);
  }


}
