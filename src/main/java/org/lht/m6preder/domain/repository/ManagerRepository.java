package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.persistence.entity.Administrativo;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository {

  List<Manager> findAll();

  Optional<Manager> findById(Long managerId);

  Manager save(Manager manager);

  void delete(Long managerId);

  Optional<Manager> getByUsuario_IdUsuario(Long userId);

}
