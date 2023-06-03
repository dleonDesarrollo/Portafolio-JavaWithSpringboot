package org.lht.m6preder.domain.dto;

import lombok.Data;

@Data
public class Inspection {

  private Long inspectionId;

  private Customer inspectedCustomer;
  private Professional inspectorProfessional;
  private String day;
  private String time;
  private String place;
  private String comment;
}
