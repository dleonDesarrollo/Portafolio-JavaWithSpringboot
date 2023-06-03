package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Inspection;

import java.util.List;
import java.util.Optional;

public interface InspectionRepository {

  List<Inspection> findAll();

  Optional<Inspection> findById(Long inspectionId);

  Inspection save(Inspection inspection);

  void delete(Long inspectionId);

  List<Inspection> findAllByProfesionalQueVisita_Usuario_IdUsuario(Long userId);
  List<Inspection> findAllByClienteVisitado_IdCliente(Long customerId);
  Integer countAllByClienteVisitado_IdCliente(Long customerId);
}
