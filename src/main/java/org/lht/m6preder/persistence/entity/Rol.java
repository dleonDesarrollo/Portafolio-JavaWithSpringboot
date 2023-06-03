package org.lht.m6preder.persistence.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idRol;
  private String nombre;



}

