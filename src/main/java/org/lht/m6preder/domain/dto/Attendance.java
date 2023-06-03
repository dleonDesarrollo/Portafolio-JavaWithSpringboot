package org.lht.m6preder.domain.dto;

import lombok.Data;

@Data
public class Attendance {


  private Long attendantId;
  private Long trainingId;
  private Attendant attendant;
  private Training training;


}
