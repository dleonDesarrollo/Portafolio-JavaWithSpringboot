package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.domain.repository.ChecklistRepository;
import org.lht.m6preder.persistence.crud.RevisionCrudRepository;
import org.lht.m6preder.persistence.entity.Revision;
import org.lht.m6preder.persistence.mapper.ChecklistMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RevisionRepository implements ChecklistRepository {

  private final RevisionCrudRepository crud;
  private final ChecklistMapper mapper;

  public RevisionRepository(RevisionCrudRepository crud, ChecklistMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Checklist> findAll() {
    return mapper.toChecklists((List<Revision>) crud.findAll());
  }

  @Override
  public Optional<Checklist> findById(Long checklistId) {
    return crud
            .findById(checklistId)
            .map(mapper::toChecklist);
  }

  @Override
  public Checklist save(Checklist checklist) {
    return mapper.toChecklist(crud.save(mapper.toRevision(checklist)));
  }

  @Override
  public void delete(Long checklistId) {
    crud.deleteById(checklistId);
  }

  @Override
  public List<Checklist> findAllByVisita_ProfesionalQueVisita_IdProfesional(Long professionalId) {
    return mapper.toChecklists((List<Revision>) crud.findAllByVisita_ProfesionalQueVisita_IdProfesional(professionalId));
  }
}
