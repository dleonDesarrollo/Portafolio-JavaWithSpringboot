package org.lht.m6preder.domain.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Professional{

  private Long professionalId;
  private User user;

  private String degree;
  private Date entryDate;
}
