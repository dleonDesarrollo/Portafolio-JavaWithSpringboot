package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Visita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitaCrudRepository extends CrudRepository<Visita, Long> {

  List<Visita> findAllByProfesionalQueVisita_Usuario_IdUsuario(Long userId);

  List<Visita> findAllByClienteVisitado_IdCliente(Long idCliente);

  Integer countAllByClienteVisitado_IdCliente(Long idCliente);

}
