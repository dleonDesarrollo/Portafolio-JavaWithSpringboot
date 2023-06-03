package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long> {

  Optional<Cliente> getByUsuario_IdUsuario(Long idUsuario);

}
