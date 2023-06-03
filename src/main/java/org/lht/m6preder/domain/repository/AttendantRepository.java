package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Attendant;

import java.util.List;
import java.util.Optional;

public interface AttendantRepository {
  List<Attendant> findAll();

  Optional<Attendant> findById(Long attendantId);

  Attendant save(Attendant attendant);

  void delete(Long attendantId);
}
