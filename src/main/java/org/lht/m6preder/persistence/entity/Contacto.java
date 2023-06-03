package org.lht.m6preder.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
  private String metodoContacto;
  private String areaContacto;
  private String razonContacto;
}
