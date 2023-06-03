package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Attendance;
import org.lht.m6preder.persistence.entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AttendantMapper.class, TrainingMapper.class})
public interface AttendanceMapper {

  @Mappings({
          @Mapping(source = "asistenciaId.idAsistente", target = "attendantId"),
          @Mapping(source = "asistenciaId.idCapacitacion", target = "trainingId"),
          @Mapping(source = "asistente", target = "attendant"),
          @Mapping(source = "capacitacion", target = "training")
  })
  Attendance toAttendance(Asistencia asistencia);
  List<Attendance> toAttendances(List<Asistencia> asistencias);
  @InheritInverseConfiguration
  Asistencia toAsistencia(Attendance attendance);

}

