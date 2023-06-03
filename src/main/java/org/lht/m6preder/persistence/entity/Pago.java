package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pago {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idPago;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_cliente", insertable = true, updatable = true)
  @ToString.Exclude
  private Cliente cliente;

  private Integer monto;
  private Date fechaPago;

}
