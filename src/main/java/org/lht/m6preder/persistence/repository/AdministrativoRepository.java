package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.repository.ManagerRepository;
import org.lht.m6preder.persistence.crud.AdministrativoCrudRepository;
import org.lht.m6preder.persistence.entity.Administrativo;
import org.lht.m6preder.persistence.mapper.ManagerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministrativoRepository implements ManagerRepository {

  private final AdministrativoCrudRepository crud;
  private final ManagerMapper mapper;

  public AdministrativoRepository(AdministrativoCrudRepository crud, ManagerMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }


  @Override
  public List<Manager> findAll() {
    return mapper.toManagers((List<Administrativo>) crud.findAll());
  }

  @Override
  public Optional<Manager> findById(Long managerId) {
    return crud
            .findById(managerId)
            .map(mapper::toManager);
  }

  @Override
  public Manager save(Manager manager) {
    return mapper.toManager(crud.save(mapper.toAdministrativo(manager)));
  }

  @Override
  public void delete(Long managerId) {
    crud.deleteById(managerId);
  }

  @Override
  public Optional<Manager> getByUsuario_IdUsuario(Long userId) {
    return crud
            .getByUsuario_IdUsuario(userId)
            .map(mapper::toManager);
  }
}
