package org.lht.m6preder.domain.service;

import org.lht.m6preder.domain.dto.Payment;
import org.lht.m6preder.domain.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

  private final PaymentRepository repo;

  public PaymentService(PaymentRepository repo) {
    this.repo = repo;
  }

  public List<Payment> findAll() {
    return repo.findAll();
  }

  public Optional<Payment> findById(Long paymentId) {
    return repo.findById(paymentId);
  }

  public Payment save(Payment payment) {
    return repo.save(payment);
  }

  public boolean delete(Long paymentId) {
    return findById(paymentId)
            .map(pay -> {
              repo.delete(paymentId);
              return true;
            }).orElse(false);
  }

  public List<Payment> findAllByCustomer(Long idCliente) {
    return repo.findAllByCliente_IdCliente(idCliente);
  }
}
