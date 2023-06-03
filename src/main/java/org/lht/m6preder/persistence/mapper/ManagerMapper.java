package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.persistence.entity.Administrativo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ManagerMapper {

  @Mappings({
          @Mapping(source = "idAdministrativo", target = "managerId"),
          @Mapping(source = "usuario", target = "user"),
          @Mapping(source = "area", target = "section"),
          @Mapping(source = "expPrevia", target = "priorExp"),

  })
  Manager toManager(Administrativo administrativo);

  List<Manager> toManagers(List<Administrativo> administrativos);

  @InheritInverseConfiguration
  Administrativo toAdministrativo(Manager manager);

}

