package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Training;
import org.lht.m6preder.persistence.entity.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface TrainingRepository {

  List<Training> findAll();

  Optional<Training> findById(Long trainingId);

  Training save(Training training);

  void delete(Long trainingId);

  List<Training> findAllByCliente_Usuario_IdUsuario(Long userId);

}
