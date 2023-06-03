package org.lht.m6preder.persistence.entity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idCliente;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_usuario", insertable = true, updatable = false)
  private Usuario usuario;

  private int rut;
  private String telefono;
  private String afp;

  @Enumerated(EnumType.STRING)
  private SistemaSalud sistemaSalud;

  private String direccion;
  private String comuna;
  private int edad;


}