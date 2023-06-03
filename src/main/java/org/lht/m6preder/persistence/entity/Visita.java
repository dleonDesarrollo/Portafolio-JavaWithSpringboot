package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Visita {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idVisita;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_cliente", insertable = true, updatable = true)
  @ToString.Exclude
  private Cliente clienteVisitado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_profesional", insertable = true, updatable = true)
  @ToString.Exclude
  private Profesional profesionalQueVisita;

  private String dia;
  private String hora;
  private String lugar;
  private String comentario;

}
