package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.UserService;
import org.lht.m6preder.persistence.entity.Contacto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/contacto")
@RequiredArgsConstructor
public class ContactoController {

  @GetMapping("/cliente/contactar")
  public String mostrarFormularioContacto() {

    return "views-cliente/contacto";
  }


  @PostMapping("/cliente/contactar")
  public String procesarContacto(Contacto contacto) {
    /*Se muestra contacto por consola, segun solicitado en SPRINT*/
    log.info("Contacto Solicitado: {}", contacto);
    return "redirect:/contacto/cliente/contactar";
  }


  @ModelAttribute(name = "contacto")
  public Contacto contacto() {
    return new Contacto();
  }
}
