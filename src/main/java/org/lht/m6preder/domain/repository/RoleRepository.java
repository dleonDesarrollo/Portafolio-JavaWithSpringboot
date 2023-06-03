package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

  List<Role> findAll();

  Optional<Role> findById(Long userId);

  Optional<Role> findByName(String name);

  Role save(Role role);

  void delete(Long userId);

}
