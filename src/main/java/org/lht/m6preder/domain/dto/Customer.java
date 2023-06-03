package org.lht.m6preder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lht.m6preder.persistence.entity.SistemaSalud;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{


  private Long customerId;
  private User user;

  private int str;
  private String phoneNumber;
  private String pfa;
  private SistemaSalud healthSystem;
  private String address;
  private String district;
  private int age;

}
