package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Capacitacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CapacitacionCrudRepository extends CrudRepository<Capacitacion, Long> {

  List<Capacitacion> findAllByCliente_Usuario_IdUsuario(Long idUsuario);

}
