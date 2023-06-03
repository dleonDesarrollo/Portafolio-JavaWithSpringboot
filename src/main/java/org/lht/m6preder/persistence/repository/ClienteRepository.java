package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.repository.CustomerRepository;
import org.lht.m6preder.persistence.crud.ClienteCrudRepository;
import org.lht.m6preder.persistence.entity.Cliente;
import org.lht.m6preder.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {


  private final ClienteCrudRepository crud;
  private final CustomerMapper mapper;


  public ClienteRepository(ClienteCrudRepository crud, CustomerMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }


  @Override
  public List<Customer> findAll() {
    return mapper.toCustomers((List<Cliente>) crud.findAll());
  }

  @Override
  public Optional<Customer> findById(Long customerId) {
    return crud
            .findById(customerId)
            .map(mapper::toCustomer);
  }

  @Override
  public Customer save(Customer customer) {
    return mapper.toCustomer(crud.save(mapper.toCliente(customer)));
  }

  @Override
  public void delete(Long customerId) {
    crud.deleteById(customerId);
  }

  @Override
  public Optional<Customer> getByUsuario_IdUsuario(Long userId) {
    return crud
            .getByUsuario_IdUsuario(userId)
            .map(mapper::toCustomer);
  }
}
