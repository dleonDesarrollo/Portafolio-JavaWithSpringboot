package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class AdministrativoController {

  private final ManagerService service;

  @GetMapping("/administrativo/nuevo")
  public String mostrarFormularioNuevoAdministrativo() {
    return "views-administrativo/formulario_administrativo";
  }

  @PostMapping("/administrativo/nuevo")
  public String addAdministrativo(Manager manager) {

    manager.getUser().getTheRoles().add(new Role(null, "ROLE_ADMIN"));

    this.service.save(manager);
    return "redirect:/usuario/administrativo/listar";
  }

  @GetMapping("/administrativo/editar/{userId}")
  public String mostrarFormularioEditarAdministrativo(@PathVariable("userId") Long userId, Model model) {

    Manager manager = service.findByUserId(userId).orElse(new Manager());
    log.info("mostrarFormularioEditarAdministrativo: {}", manager);
    model.addAttribute("theManager", manager);

    return "views-administrativo/formulario_administrativo_editar";
  }

  @ModelAttribute(name = "administrativo")
  public Manager administrativo() {
    return new Manager();
  }


}
