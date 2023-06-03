package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Pago;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagoCrudRepository extends CrudRepository<Pago, Long> {

  List<Pago> findAllByCliente_IdCliente(Long idCliente);

}
