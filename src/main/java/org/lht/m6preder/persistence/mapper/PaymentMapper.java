package org.lht.m6preder.persistence.mapper;

import org.lht.m6preder.domain.dto.Payment;
import org.lht.m6preder.persistence.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface PaymentMapper {

  @Mappings({
          @Mapping(source = "idPago", target = "paymentId"),
          @Mapping(source = "cliente", target = "customer"),
          @Mapping(source = "monto", target = "amount"),
          @Mapping(source = "fechaPago", target = "paymentDate")
  })
  Payment toPayment(Pago pago);

  List<Payment> toPayments(List<Pago> pagos);

  @InheritInverseConfiguration
  Pago toPago(Payment payment);

}
