package org.lht.m6preder.domain.service;

import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.domain.repository.ChecklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

  private final ChecklistRepository repo;

  public ChecklistService(ChecklistRepository repo) {
    this.repo = repo;
  }

  public List<Checklist> findAll() {
    return repo.findAll();
  }

  public Optional<Checklist> findById(Long checklistId) {
    return repo.findById(checklistId);
  }

  public Checklist save(Checklist checklist) {
    return repo.save(checklist);
  }

  public boolean delete(Long checklistId) {
    return findById(checklistId)
            .map(check -> {
              repo.delete((checklistId));
              return true;
            }).orElse(false);
  }

  public List<Checklist> findAllByProfessionalId(Long professionalId) {
    return repo.findAllByVisita_ProfesionalQueVisita_IdProfesional(professionalId);
  }
}
