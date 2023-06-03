package org.lht.m6preder.persistence.entity;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Capacitacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCapacitacion;

  private int rutCliente;
  private String dia;
  private String hora;
  private String lugar;
  private int duracion;
  private int cantidadAsistentes;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_cliente")//, insertable = false, updatable = false
  @ToString.Exclude
  private Cliente cliente;

}
