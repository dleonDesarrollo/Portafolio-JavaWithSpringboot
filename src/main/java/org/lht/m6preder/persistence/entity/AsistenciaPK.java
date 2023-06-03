package org.lht.m6preder.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class AsistenciaPK  implements Serializable {

  private Long idAsistente;
  private Long idCapacitacion;

  public Long getIdAsistente() {
    return idAsistente;
  }

  public void setIdAsistente(Long idAsistente) {
    this.idAsistente = idAsistente;
  }

  public Long getIdCapacitacion() {
    return idCapacitacion;
  }

  public void setIdCapacitacion(Long idCapacitacion) {
    this.idCapacitacion = idCapacitacion;
  }

  public AsistenciaPK(Long idAsistente, Long idCapacitacion) {
    this.idAsistente = idAsistente;
    this.idCapacitacion = idCapacitacion;
  }

  public AsistenciaPK() {
  }
}
