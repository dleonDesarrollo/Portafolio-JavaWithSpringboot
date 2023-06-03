package org.lht.m6preder.domain.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.CustomerService;
import org.lht.m6preder.domain.service.ManagerService;
import org.lht.m6preder.domain.service.ProfessionalService;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class UserRoleAdvice {

  private final UserService service;
  private final CustomerService customerService;
  private final ManagerService managerService;
  private final ProfessionalService professionalService;

  @ModelAttribute("usuarioId")
  public Long getUserId() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> user = service.findUserByUsername(auth.getName());
    User theUser;
    if (user.isPresent()) {
      theUser = user.get();
      log.info("CURRENT USER ID: {}", theUser.getUserId());
      return theUser.getUserId();

    } else {
      return 0L;
    }
  }

  @ModelAttribute("nameOfRole")
  public String getUserRol() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> user = service.findUserByUsername(auth.getName());
    User theUser;
    if (user.isPresent()) {
      theUser = user.get();
      log.info("CURRENT USER ROL: {}", theUser.getTheRoles().stream().findFirst().get().getName());
      return theUser.getTheRoles().stream().findFirst().get().getName();
    } else {
      return "";
    }
  }

  //Usar el Rol para definir si obtener la idCLIENTE, idPROFESIONAL o idADMIN,y acoplarla al modelo bajo "idForRole"
  @ModelAttribute("idForRole")
  public Long getIDforRole() {
    String role = getUserRol();

    if (role.trim().equals("ROLE_CLIENTE")) {
      Customer customer = this.customerService.findByUserId(this.getUserId()).get();
      log.info("CURRENT idForRole: {}", customer.getCustomerId());

      return customer.getCustomerId();
    } else if (role.trim().equals("ROLE_ADMIN")) {
      Manager manager = this.managerService.findByUserId(this.getUserId()).get();
      log.info("CURRENT idForRole: {}", manager.getManagerId());

      return manager.getManagerId();
    } else if (role.trim().equals("ROLE_PROFE")) {
      Professional professional = this.professionalService.findByUserId(this.getUserId()).get();
      log.info("CURRENT idForRole: {}", professional.getProfessionalId());

      return professional.getProfessionalId();
    } else {
      return 0L;
    }

  }


  @ModelAttribute("usuarioNombre")
  public String getUserName() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> user = service.findUserByUsername(auth.getName());
    User theUser;
    if (user.isPresent()) {
      theUser = user.get();
      log.info("CURRENT USER NAME: {}", theUser.getName());
      return theUser.getName();
    } else {
      return "";
    }
  }
}
