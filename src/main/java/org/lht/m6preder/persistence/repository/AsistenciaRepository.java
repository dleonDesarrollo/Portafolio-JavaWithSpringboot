package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Attendance;
import org.lht.m6preder.domain.repository.AttendanceRepository;
import org.lht.m6preder.persistence.crud.AsistenciaCrudRepository;
import org.lht.m6preder.persistence.entity.Asistencia;
import org.lht.m6preder.persistence.entity.AsistenciaPK;
import org.lht.m6preder.persistence.mapper.AttendanceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AsistenciaRepository implements AttendanceRepository {


  private final AsistenciaCrudRepository crud;
  private final AttendanceMapper mapper;

  public AsistenciaRepository(AsistenciaCrudRepository crud, AttendanceMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Attendance> findAll() {
    return mapper.toAttendances((List<Asistencia>) crud.findAll());
  }

  @Override
  public Optional<Attendance> findById(Long attendanceId, Long trainingId) {
    return crud
            .findById(new AsistenciaPK(attendanceId, trainingId))
            .map(mapper::toAttendance);
  }

  @Override
  public Attendance save(Attendance attendance) {
    return mapper.toAttendance(crud.save(mapper.toAsistencia(attendance)));
  }

  @Override
  public void delete(Long attendanceId, Long trainingId) {
    crud.deleteById(new AsistenciaPK(attendanceId, trainingId));
  }

}
