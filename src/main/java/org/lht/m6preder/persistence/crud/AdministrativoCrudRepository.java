package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Administrativo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdministrativoCrudRepository extends CrudRepository<Administrativo, Long> {

  Optional<Administrativo> getByUsuario_IdUsuario(Long idUsuario);
}
