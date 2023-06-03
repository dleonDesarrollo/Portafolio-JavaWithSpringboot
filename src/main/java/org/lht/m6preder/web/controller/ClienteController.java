package org.lht.m6preder.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/customer")
public class ClienteController {

  private final CustomerService service;

  public ClienteController(CustomerService service) {
    this.service = service;
  }

  @GetMapping("/administrativo/nuevo")
  public String mostrarFormularioNuevoCliente() {
    return "views-administrativo/formulario_cliente";
  }

  @PostMapping("/administrativo/nuevo")
  public String addCliente(Customer customer) {
    log.info("Cliente creado: {}", customer);
    customer.getUser().getTheRoles().add(new Role(null, "ROLE_CLIENTE"));
    this.service.save(customer);
    return "redirect:/usuario/administrativo/listar";
  }

  @PostMapping("/administrativo/editar")
  public String editarCliente(Customer customer) {
    log.info("Editando: {}", customer);
    customer.getUser().getTheRoles().add(new Role(null, "ROLE_CLIENTE"));
    this.service.save(customer);
    return "redirect:/usuario/administrativo/listar";
  }


  @GetMapping("/administrativo/editar/{userId}")
  public String mostrarFormularioEditarCliente(@PathVariable("userId") Long userId, Model model) {

    Customer customer = service.findByUserId(userId).orElse(new Customer());
    model.addAttribute("theCustomer", customer);
    log.info("CLIENTE ENCONTRADO: {}", customer);
    return "views-administrativo/formulario_cliente_editar";
  }


  @ModelAttribute(name = "cliente")
  public Customer cliente() {
    return new Customer();
  }


}
