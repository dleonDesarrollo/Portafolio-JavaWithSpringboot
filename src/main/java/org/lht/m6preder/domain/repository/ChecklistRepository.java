package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.persistence.entity.Revision;

import java.util.List;
import java.util.Optional;

public interface ChecklistRepository {
  List<Checklist> findAll();

  Optional<Checklist> findById(Long checklistId);

  Checklist save(Checklist checklist);

  void delete(Long checklistId);

  List<Checklist> findAllByVisita_ProfesionalQueVisita_IdProfesional(Long professionalId);
}
