package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Revision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RevisionCrudRepository extends CrudRepository<Revision, Long> {

  List<Revision> findAllByVisita_ProfesionalQueVisita_IdProfesional(Long idProfesional);

}
