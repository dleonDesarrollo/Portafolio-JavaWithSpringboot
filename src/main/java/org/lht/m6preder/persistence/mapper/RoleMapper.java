package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.persistence.entity.Rol;
import org.lht.m6preder.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  @Mappings({
          @Mapping(source = "idRol", target = "roleId"),
          @Mapping(source = "nombre", target = "name")
  })
  Role toRole(Rol rol);

  List<Role> toRoles(List<Rol> losRoles);

  @InheritInverseConfiguration
  Rol toRol(Role role);

}
