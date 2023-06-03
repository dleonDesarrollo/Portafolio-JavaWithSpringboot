package org.lht.m6preder.domain.dto;

import lombok.Data;
import org.lht.m6preder.persistence.entity.EstadoRevision;


@Data
public class Checklist {

  private Long checklistId;

  private Inspection inspection;
  private EstadoRevision checklistStatus;
  private String details;

}
