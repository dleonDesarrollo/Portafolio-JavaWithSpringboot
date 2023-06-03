package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.repository.ProfessionalRepository;
import org.lht.m6preder.persistence.crud.AsistenteCrudRepository;
import org.lht.m6preder.persistence.crud.ProfesionalCrudRepository;
import org.lht.m6preder.persistence.entity.Profesional;
import org.lht.m6preder.persistence.mapper.AttendantMapper;
import org.lht.m6preder.persistence.mapper.ProfessionalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesionalRepository implements ProfessionalRepository {

  private final ProfesionalCrudRepository crud;
  private final ProfessionalMapper mapper;

  public ProfesionalRepository(ProfesionalCrudRepository crud, ProfessionalMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Professional> findAll() {
    return mapper.toProfessionals((List<Profesional>) crud.findAll());
  }

  @Override
  public Optional<Professional> findById(Long professionalId) {
    return crud
            .findById(professionalId)
            .map(mapper::toProfessional);
  }

  @Override
  public Professional save(Professional professional) {
    return mapper.toProfessional(crud.save(mapper.toProfesional(professional)));
  }

  @Override
  public void delete(Long professionalId) {
    crud.deleteById(professionalId);
  }

  @Override
  public Optional<Professional> getByUsuario_IdUsuario(Long userId) {
    return crud
            .getByUsuario_IdUsuario(userId)
            .map(mapper::toProfessional);
  }
}
