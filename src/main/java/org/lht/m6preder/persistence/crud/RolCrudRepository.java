package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolCrudRepository extends CrudRepository<Rol, Long> {

  Optional<Rol> findByNombre(String nombre);
}
