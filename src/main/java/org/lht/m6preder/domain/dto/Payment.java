package org.lht.m6preder.domain.dto;

import lombok.Data;
import org.lht.m6preder.persistence.entity.Cliente;
import java.sql.Date;

@Data
public class Payment {
  private Long paymentId;

  private Customer customer;
  private Integer amount;
  private Date paymentDate;
}
