package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Asistente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAsistente;

  private Integer rut;
  private String nombre;

}
