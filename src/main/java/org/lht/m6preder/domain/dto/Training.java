package org.lht.m6preder.domain.dto;

import lombok.Data;
import org.lht.m6preder.persistence.entity.Cliente;

@Data
public class Training {

  private Long trainingID;
  private int customerStr;
  private String day;
  private String time;
  private String place;
  private int duration;
  private int numberOfAttendants;
  private Customer customer;
}
