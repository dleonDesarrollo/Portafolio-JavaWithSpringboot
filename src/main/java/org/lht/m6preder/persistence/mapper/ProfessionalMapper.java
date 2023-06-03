package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.persistence.entity.Profesional;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProfessionalMapper {

  @Mappings({
          @Mapping(source = "idProfesional", target = "professionalId"),
          @Mapping(source = "usuario", target = "user"),
          @Mapping(source = "titulo", target = "degree"),
          @Mapping(source = "fechaIngreso", target = "entryDate"),

  })
  Professional toProfessional(Profesional profesional);

  List<Professional> toProfessionals(List<Profesional> profesionales);

  @InheritInverseConfiguration
  Profesional toProfesional(Professional professional);

}
