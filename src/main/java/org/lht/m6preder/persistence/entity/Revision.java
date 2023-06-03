package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Revision {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idRevision;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_visita", insertable = true, updatable = true)
  @ToString.Exclude
  private Visita visita;

  @Enumerated(EnumType.STRING)
  private EstadoRevision estadoRevision;

  private String detalle;





}
