package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "profesional")
public class Profesional {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idProfesional;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_usuario", insertable = true, updatable = false)
  private Usuario usuario;

  private String titulo;
  private Date fechaIngreso;

}
