package org.lht.m6preder.persistence.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUsuario;
  private String nombreUsuario;
  private String contrasenia;

  private String nombre;
  private Date fechaNacimiento;
  private Integer run;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Rol> losRoles = new ArrayList<>();

  @CreationTimestamp
  private Timestamp ultimaActualizacion;



}


