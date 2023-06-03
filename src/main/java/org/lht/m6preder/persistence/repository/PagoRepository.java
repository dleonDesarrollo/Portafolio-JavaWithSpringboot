package org.lht.m6preder.persistence.repository;

import org.lht.m6preder.domain.dto.Payment;
import org.lht.m6preder.domain.repository.PaymentRepository;
import org.lht.m6preder.persistence.crud.PagoCrudRepository;
import org.lht.m6preder.persistence.entity.Pago;
import org.lht.m6preder.persistence.mapper.PaymentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PagoRepository implements PaymentRepository {

  private final PagoCrudRepository crud;
  private final PaymentMapper mapper;

  public PagoRepository(PagoCrudRepository crud, PaymentMapper mapper) {
    this.crud = crud;
    this.mapper = mapper;
  }

  @Override
  public List<Payment> findAll() {
    return mapper.toPayments((List<Pago>) crud.findAll());
  }

  @Override
  public Optional<Payment> findById(Long paymentId) {
    return crud
            .findById(paymentId)
            .map(mapper::toPayment);
  }

  @Override
  public Payment save(Payment payment) {
    return mapper.toPayment(crud.save(mapper.toPago(payment)));
  }

  @Override
  public void delete(Long paymentId) {
    crud.deleteById(paymentId);
  }

  @Override
  public List<Payment> findAllByCliente_IdCliente(Long customerId) {
    return mapper.toPayments((List<Pago>) crud.findAllByCliente_IdCliente(customerId));
  }
}
