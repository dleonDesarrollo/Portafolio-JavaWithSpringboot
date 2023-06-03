package org.lht.m6preder.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class InicioController {


  @GetMapping("/")
  public String mostrarInicio(Model model) {

    log.info("ROLE CARGADO AL INICIO: {}",model.getAttribute("nameOfRole"));
    return "views-general/inicio";
  }
}
