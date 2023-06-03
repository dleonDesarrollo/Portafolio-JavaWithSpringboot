package org.lht.m6preder.domain.service;

import org.lht.m6preder.domain.dto.Training;
import org.lht.m6preder.domain.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

  private final TrainingRepository repo;

  public TrainingService(TrainingRepository repo) {
    this.repo = repo;
  }

  public List<Training> findAll() {
    return repo.findAll();
  }

  public Optional<Training> findById(Long trainingId) {
    return repo.findById(trainingId);
  }

  public Training save(Training training) {
    return repo.save(training);
  }

  public boolean delete(Long trainingId) {
    return findById(trainingId)
            .map(capa -> {
              repo.delete(trainingId);
              return true;
            }).orElse(false);
  }

  public List<Training> findAllByUserId(Long userId) {
    return repo.findAllByCliente_Usuario_IdUsuario(userId);
  }


}
