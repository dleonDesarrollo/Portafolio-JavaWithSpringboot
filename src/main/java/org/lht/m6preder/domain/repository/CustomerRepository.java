package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

  List<Customer> findAll();

  Optional<Customer> findById(Long customerId);

  Customer save(Customer customer);

  void delete(Long customerId);

  Optional<Customer> getByUsuario_IdUsuario(Long userId);
}
