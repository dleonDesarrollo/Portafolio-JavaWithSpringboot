package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Attendant;
import org.lht.m6preder.persistence.entity.Asistente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendantMapper {

  @Mappings({
          @Mapping(source = "idAsistente", target = "attendantId"),
          @Mapping(source = "rut", target = "dni"),
          @Mapping(source = "nombre", target = "name")
  })
  Attendant toAttendant(Asistente asistente);

  List<Attendant> toAttendants(List<Asistente> asistentes);

  @InheritInverseConfiguration
  Asistente toAsistente(Attendant attendant);

}
