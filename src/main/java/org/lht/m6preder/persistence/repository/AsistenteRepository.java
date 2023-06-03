package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Attendant;
import org.lht.m6preder.domain.repository.AttendantRepository;
import org.lht.m6preder.persistence.crud.AsistenteCrudRepository;
import org.lht.m6preder.persistence.entity.Asistente;
import org.lht.m6preder.persistence.mapper.AttendantMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AsistenteRepository implements AttendantRepository {

  private final AsistenteCrudRepository crud;
  private final AttendantMapper mapper;

  public AsistenteRepository(AsistenteCrudRepository crud, AttendantMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Attendant> findAll() {
    return mapper.toAttendants((List<Asistente>) crud.findAll());
  }

  @Override
  public Optional<Attendant> findById(Long attendantId) {
    return crud
            .findById(attendantId)
            .map(mapper::toAttendant);
  }

  @Override
  public Attendant save(Attendant attendant) {
    return mapper.toAttendant(crud.save(mapper.toAsistente(attendant)));
  }

  @Override
  public void delete(Long attendantId) {
    crud.deleteById(attendantId);
  }
}
