package org.lht.m6preder.domain.service;

import org.lht.m6preder.domain.dto.Attendance;
import org.lht.m6preder.domain.dto.Attendant;
import org.lht.m6preder.domain.repository.AttendantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendantService {

  private final AttendantRepository repo;

  public AttendantService(AttendantRepository repo) {
    this.repo = repo;
  }

  public List<Attendant> findAll() {
    return repo.findAll();
  }

  public Optional<Attendant> findById(Long attendantId) {
    return repo.findById(attendantId);
  }

  public Attendant save(Attendant attendant) {
    return repo.save(attendant);
  }

  public boolean delete(Long attendantId) {
    return findById(attendantId)
            .map(att -> {
              repo.delete(attendantId);
              return true;
            }).orElse(false);
  }
}
