package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository {
  List<Attendance> findAll();

  Optional<Attendance> findById(Long attendanceId, Long trainingId);

  Attendance save(Attendance attendance);

  void delete(Long attendanceId, Long trainingId);
}
