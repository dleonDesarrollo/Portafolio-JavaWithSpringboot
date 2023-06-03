package org.lht.m6preder.domain.service;

import org.lht.m6preder.domain.dto.Attendance;
import org.lht.m6preder.domain.repository.AttendanceRepository;
import org.lht.m6preder.domain.repository.AttendantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

  private final AttendanceRepository repo;

  public AttendanceService(AttendanceRepository repo) {
    this.repo = repo;
  }

  public List<Attendance> findAll() {
    return repo.findAll();
  }

  /*Esto puede fallar TODO revisar*/
  public Optional<Attendance> findById(Long attendantId, Long trainingId) {
    return repo.findById(attendantId, trainingId);
  }

  public Attendance save(Attendance attendance) {
    return repo.save(attendance);
  }

  public boolean delete(Long attendantId, Long trainingId) {
    return findById(attendantId, trainingId)
            .map(att -> {
              repo.delete(attendantId, trainingId);
              return true;
            }).orElse(false);
  }

}
