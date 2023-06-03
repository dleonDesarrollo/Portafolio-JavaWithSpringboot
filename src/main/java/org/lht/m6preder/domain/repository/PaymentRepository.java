package org.lht.m6preder.domain.repository;

import org.lht.m6preder.domain.dto.Payment;
import org.lht.m6preder.persistence.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {

  List<Payment> findAll();

  Optional<Payment> findById(Long paymentId);

  Payment save(Payment payment);

  void delete(Long paymentId);
  List<Payment> findAllByCliente_IdCliente(Long customerId);

}
