package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Inspection;
import org.lht.m6preder.persistence.entity.Visita;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProfessionalMapper.class})
public interface InspectionMapper {

  @Mappings({
          @Mapping(source = "idVisita", target = "inspectionId"),
          @Mapping(source = "clienteVisitado", target = "inspectedCustomer"),
          @Mapping(source = "profesionalQueVisita", target = "inspectorProfessional"),
          @Mapping(source = "dia", target = "day"),
          @Mapping(source = "hora", target = "time"),
          @Mapping(source = "lugar", target = "place"),
          @Mapping(source = "comentario", target = "comment")
  })
  Inspection toInspection(Visita visita);

  List<Inspection> toInspections(List<Visita> visitas);

  @InheritInverseConfiguration
  Visita toVisita(Inspection inspection);

}

