package org.lht.m6preder.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.repository.RoleRepository;
import org.lht.m6preder.persistence.crud.RolCrudRepository;
import org.lht.m6preder.persistence.entity.Rol;
import org.lht.m6preder.persistence.mapper.RoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RolRepository implements RoleRepository {

  private final RolCrudRepository crud;
  private final RoleMapper mapper;

  @Override
  public List<Role> findAll() {
    return mapper.toRoles((List<Rol>) crud.findAll());
  }

  @Override
  public Optional<Role> findById(Long userId) {
    return crud
            .findById(userId)
            .map(mapper::toRole);
  }

  @Override
  public Optional<Role> findByName(String name) {
    return crud
            .findByNombre(name)
            .map(mapper::toRole);
  }

  @Override
  public Role save(Role role) {
    return mapper.toRole(crud.save(mapper.toRol(role)));
  }

  @Override
  public void delete(Long userId) {
    crud.deleteById(userId);
  }


}
