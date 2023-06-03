package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.service.CustomerService;
import org.lht.m6preder.domain.service.ManagerService;
import org.lht.m6preder.domain.service.ProfessionalService;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

  private final UserService service;
  private final CustomerService customerService;
  private final ProfessionalService professionalService;
  private final ManagerService managerService;


  @GetMapping("/administrativo/listar")
  public String listar(Model model) {
    model.addAttribute("listaUsuarios", this.service.findAll());
    return "views-administrativo/lista_usuarios";
  }




}



