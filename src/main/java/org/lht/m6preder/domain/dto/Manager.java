package org.lht.m6preder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

  private Long managerId;
  private User user;

  private String section;
  private String priorExp;
}
