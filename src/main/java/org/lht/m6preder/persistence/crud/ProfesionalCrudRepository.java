package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Administrativo;
import org.lht.m6preder.persistence.entity.Profesional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfesionalCrudRepository extends CrudRepository<Profesional, Long> {

  Optional<Profesional> getByUsuario_IdUsuario(Long idUsuario);
}
