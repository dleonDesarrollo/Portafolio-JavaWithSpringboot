package org.lht.m6preder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long userId;


  private String username;
  private String password;

  private String name;
  private Date birthday;
  private Integer dni;

  private Collection<Role> theRoles = new ArrayList<>();

  private Timestamp updatedAt;

  public String getFirstRole() {//ADMIN O PROFE O CLIENTE
    if (!theRoles.isEmpty()) {
      Role role = theRoles.stream().findFirst().get();
      String parsedRole = role.getName().substring(5);

      return parsedRole;
    }

    return "ROL NO ESPECIFICADO";
  }

  public String getFormattedRole() {
    if ("ADMIN".equalsIgnoreCase(getFirstRole())) {
      return "manager";
    }
    if ("PROFE".equalsIgnoreCase(getFirstRole())) {
      return "professional";
    }
    if ("CLIENTE".equalsIgnoreCase(getFirstRole())) {
      return "customer";
    }
    return "ROL SIN DEFINIR";
  }


}
