package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Asistencia;
import org.lht.m6preder.persistence.entity.AsistenciaPK;
import org.springframework.data.repository.CrudRepository;

public interface AsistenciaCrudRepository extends CrudRepository<Asistencia, AsistenciaPK> {
}
