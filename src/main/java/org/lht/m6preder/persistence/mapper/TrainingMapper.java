package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Training;
import org.lht.m6preder.persistence.entity.Capacitacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface TrainingMapper {

  @Mappings({
          @Mapping(source = "idCapacitacion", target = "trainingID"),
          @Mapping(source = "rutCliente", target = "customerStr"),
          @Mapping(source = "dia", target = "day"),
          @Mapping(source = "hora", target = "time"),
          @Mapping(source = "lugar", target = "place"),
          @Mapping(source = "duracion", target = "duration"),
          @Mapping(source = "cantidadAsistentes", target = "numberOfAttendants"),
          @Mapping(source = "cliente", target = "customer")
  })
  Training toTraining(Capacitacion capacitacion);

  List<Training> toTrainings(List<Capacitacion> capacitaciones);

  @InheritInverseConfiguration
  Capacitacion toCapacitacion(Training training);

}
