package org.lht.m6preder.persistence.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Asistencia {

  @EmbeddedId
  private AsistenciaPK asistenciaId;

  @ManyToOne
  @MapsId("idAsistente")
  private Asistente asistente;

  @ManyToOne
  @MapsId("idCapacitacion")
  private Capacitacion capacitacion;

  public AsistenciaPK getAsistenciaId() {
    return asistenciaId;
  }

  public void setAsistenciaId(AsistenciaPK asistenciaId) {
    this.asistenciaId = asistenciaId;
  }

  public Asistente getAsistente() {
    return asistente;
  }

  public void setAsistente(Asistente asistente) {
    this.asistente = asistente;
  }

  public Capacitacion getCapacitacion() {
    return capacitacion;
  }

  public void setCapacitacion(Capacitacion capacitacion) {
    this.capacitacion = capacitacion;
  }

  public Asistencia(AsistenciaPK asistenciaId, Asistente asistente, Capacitacion capacitacion) {
    this.asistenciaId = asistenciaId;
    this.asistente = asistente;
    this.capacitacion = capacitacion;
  }

  public Asistencia() {
  }
}
