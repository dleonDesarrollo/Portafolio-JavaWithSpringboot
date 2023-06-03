package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Checklist;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Inspection;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.service.ChecklistService;
import org.lht.m6preder.domain.service.InspectionService;
import org.lht.m6preder.persistence.entity.EstadoRevision;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/revision")
public class RevisionController {

  private final ChecklistService revisionService;
  private final InspectionService inspectionService;


  @GetMapping("/administrativo/listar")
  public String listar(Model model) {
    model.addAttribute("listaRevisiones", this.revisionService.findAll());
    return "views-administrativo/lista_revisiones";
  }

  @GetMapping("/profesional/listar")
  public String listarByProfesional(Model model) {
    Long idProfe = (Long) model.getAttribute("idForRole");

    log.info("Lista Revisiones asociadas a {} : {}", idProfe, this.revisionService.findAllByProfessionalId(idProfe));


    model.addAttribute("listaRevisiones", this.revisionService.findAllByProfessionalId(idProfe));
    return "views-profesional/lista_revisiones";

  }

  @GetMapping("/administrativo/nuevo/{idVisita}")
  public String mostrarFormularioNuevaRevision(@PathVariable(name = "idVisita") Long idVisita, Model model) {

    Inspection inspection = inspectionService.findById(idVisita).get();
    List<EstadoRevision> estados = Arrays.asList(EstadoRevision.values());


    model.addAttribute("inspection", inspection);
    model.addAttribute("estados", estados);
    return "views-administrativo/formulario_revision";
  }


  @PostMapping("/administrativo/nuevo/{idVisita}")
  public String addRevision(@PathVariable(name = "idVisita") Long idVisita, Checklist revision, Model model) {

    Inspection inspection = inspectionService.findById(idVisita).get();

    revision.setInspection(inspection);
    revision.setChecklistStatus(EstadoRevision.NO_ASIGNADO);
    this.revisionService.save(revision);

    return "redirect:/revision/administrativo/listar";
  }


  @GetMapping("/administrativo/editar/{idRevision}")
  public String mostrarFormularioEditarRevision(@PathVariable(name = "idRevision") Long idRevision, Model model) {

    Checklist checklist = revisionService.findById(idRevision).get();
    List<EstadoRevision> estados = Arrays.asList(EstadoRevision.values());


    model.addAttribute("revision", checklist);
    model.addAttribute("estados", estados);
    return "views-administrativo/formulario_revision_editar";
  }

  @GetMapping("/profesional/editar/{idRevision}")
  public String mostrarFormularioEditarRevisionProf(@PathVariable(name = "idRevision") Long idRevision, Model model) {

    Checklist checklist = revisionService.findById(idRevision).get();
    List<EstadoRevision> estados = Arrays.asList(EstadoRevision.values());


    model.addAttribute("revision", checklist);
    model.addAttribute("estados", estados);
    return "views-profesional/formulario_revision_editar";
  }


  @PostMapping("/administrativo/editar/{idRevision}")
  public String editarRevision(@PathVariable(name = "idRevision") Long idRevision, Checklist revision, Model model) {

    this.revisionService.save(revision);

    return "redirect:/revision/administrativo/listar";
  }


  @PostMapping("/profesional/editar/{idRevision}")
  public String editarRevisionProf(@PathVariable(name = "idRevision") Long idRevision, Checklist revision, Model model) {

    this.revisionService.save(revision);

    return "redirect:/revision/profesional/listar";
  }
}
