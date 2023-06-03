package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.service.ProfessionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/professional")
public class ProfesionalController {

  private final ProfessionalService service;


  @GetMapping("/administrativo/nuevo")
  public String mostrarFormularioNuevoProfesional() {
    return "views-administrativo/formulario_profesional";
  }

  @PostMapping("/administrativo/nuevo")
  public String addProfesional(Professional professional) {

    professional.getUser().getTheRoles().add(new Role(null, "ROLE_PROFE"));
    this.service.save(professional);

    return "redirect:/usuario/administrativo/listar";
  }

  @PostMapping("/administrativo/editar")
  public String editProfesional(Professional professional) {

    professional.getUser().getTheRoles().add(new Role(null, "ROLE_PROFE"));
    this.service.save(professional);

    return "redirect:/usuario/administrativo/listar";
  }



  @GetMapping("/administrativo/editar/{userId}")
  public String mostrarFormularioEditarProfesional(@PathVariable("userId") Long userId, Model model) {

    Professional professional = service.findByUserId(userId).orElse(new Professional());
    model.addAttribute("theProfessional", professional);

    return "views-administrativo/formulario_profesional_editar";
  }




  @ModelAttribute(name = "profesional")
  public Professional profesional() {
    return new Professional();
  }
}
