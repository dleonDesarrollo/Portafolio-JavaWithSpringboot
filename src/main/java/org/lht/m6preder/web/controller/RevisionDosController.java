package org.lht.m6preder.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.domain.service.ChecklistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/revisionDos")
public class RevisionDosController {


  private final ChecklistService service;

  public RevisionDosController(ChecklistService service) {
    this.service = service;
  }

  // administrativo crea un formulario de revision
  @GetMapping("/nueva")
  public String mostrarFormularioNuevaRevision(){
    return "views-administrativo/formulario_revision";
  }

  @PostMapping("/nueva")
  public String addrevision(Checklist checklist) {
    log.info("Revision creada: {} ", checklist);

    this.service.save(checklist);
    return "redirect:/revision/listar";
  }

  @GetMapping("/listar")
  public String listar(Model model) {
    model.addAttribute("listaRevisiones", this.service.findAll());
    return "views-administrativo/lista_revisiones";
  }


  @GetMapping("/editar")
  public String mostrarFormularioEditarRevision() {
    return "views-profesional/formulario-editarRevision";
  }


  @ModelAttribute(name = "revision")
  public Checklist revision() {
    return new Checklist();
  }






}
