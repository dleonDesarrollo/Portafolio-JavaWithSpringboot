package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Training;
import org.lht.m6preder.domain.repository.TrainingRepository;
import org.lht.m6preder.persistence.crud.CapacitacionCrudRepository;
import org.lht.m6preder.persistence.entity.Capacitacion;
import org.lht.m6preder.persistence.mapper.TrainingMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CapacitacionRepository implements TrainingRepository {

  private final CapacitacionCrudRepository crud;
  private final TrainingMapper mapper;

  public CapacitacionRepository(CapacitacionCrudRepository crud, TrainingMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Training> findAll() {
    return mapper.toTrainings((List<Capacitacion>) crud.findAll());
  }

  @Override
  public Optional<Training> findById(Long trainingId) {
    return crud
            .findById(trainingId)
            .map(mapper::toTraining);
  }

  @Override
  public Training save(Training training) {
    return mapper.toTraining(crud.save(mapper.toCapacitacion(training)));
  }

  @Override
  public void delete(Long trainingId) {
    crud.deleteById(trainingId);
  }

  @Override
  public List<Training> findAllByCliente_Usuario_IdUsuario(Long userId) {
    return mapper.toTrainings((List<Capacitacion>) crud.findAllByCliente_Usuario_IdUsuario(userId));
  }


}
