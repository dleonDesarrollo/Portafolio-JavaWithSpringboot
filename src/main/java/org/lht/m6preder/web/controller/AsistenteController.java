package org.lht.m6preder.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Attendant;
import org.lht.m6preder.domain.service.AttendantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class AsistenteController {

  private final AttendantService service;

  public AsistenteController(AttendantService service) {
    this.service = service;
  }

  @GetMapping("/nuevo")
  public String mostrarFormularioNuevoAsistente() {
    return "views-cliente/formulario_asistentes";
  }

  @PostMapping("/nuevo")
  public String addAsistente(Attendant attendant) {
    log.info("Asistente ingresado: {}", attendant );

    this.service.save(attendant);
    return "redirect:/asistente/listar";
  }

  @GetMapping("/listar")
  public String listar (Model model) {
    model.addAttribute("listarAsistentes", this.service.findAll());
    return "views-cliente/listar_asistentes";
  }

  @ModelAttribute(name = "asistente")
  public Attendant asistente() {
    return new Attendant();
  }
}

















