package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Inspection;
import org.lht.m6preder.domain.repository.InspectionRepository;
import org.lht.m6preder.persistence.crud.CapacitacionCrudRepository;
import org.lht.m6preder.persistence.crud.VisitaCrudRepository;
import org.lht.m6preder.persistence.entity.Visita;
import org.lht.m6preder.persistence.mapper.InspectionMapper;
import org.lht.m6preder.persistence.mapper.TrainingMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VisitaRepository implements InspectionRepository {

  private final VisitaCrudRepository crud;
  private final InspectionMapper mapper;

  public VisitaRepository(VisitaCrudRepository crud, InspectionMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Inspection> findAll() {
    return mapper.toInspections((List<Visita>) crud.findAll());
  }

  @Override
  public Optional<Inspection> findById(Long inspectionId) {
    return crud
            .findById(inspectionId)
            .map(mapper::toInspection);
  }

  @Override
  public Inspection save(Inspection inspection) {
    return mapper.toInspection(crud.save(mapper.toVisita(inspection)));
  }

  @Override
  public void delete(Long inspectionId) {
    crud.deleteById(inspectionId);

  }

  @Override
  public List<Inspection> findAllByProfesionalQueVisita_Usuario_IdUsuario(Long userId) {
    return mapper.toInspections(crud.findAllByProfesionalQueVisita_Usuario_IdUsuario(userId));
  }

  @Override
  public List<Inspection> findAllByClienteVisitado_IdCliente(Long customerId) {
    return mapper.toInspections(crud.findAllByClienteVisitado_IdCliente(customerId));
  }

  @Override
  public Integer countAllByClienteVisitado_IdCliente(Long customerId) {
    return crud.countAllByClienteVisitado_IdCliente(customerId);
  }
}
