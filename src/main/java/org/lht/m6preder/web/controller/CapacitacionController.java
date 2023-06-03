package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Training;

import org.lht.m6preder.domain.service.CustomerService;
import org.lht.m6preder.domain.service.TrainingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/capacitacion")
@RequiredArgsConstructor
public class CapacitacionController {

  private final TrainingService service;
  private final CustomerService customerService;


  @GetMapping("/cliente/nueva")
  public String mostrarFormularioNuevaCapacitacion(Model model) {
    Long idCliente = (Long) model.getAttribute("idForRole");
    Customer customer = this.customerService.findById(idCliente).get();

    model.addAttribute("customer", customer);

    return "views-cliente/formulario_capacitacion";
  }

  @GetMapping("/cliente/editar")
  public String mostrarFormularioEditarCapacitacion() {
    return "views-cliente/formulario_editarCapacitacion";
  }

  @PostMapping("/cliente/nueva")
  public String addCapacitacion(Training training, Model model) {
    log.info("Capacitacion creada: {}", training);

    Customer customer = customerService.findById((Long) model.getAttribute("idForRole")).get();

    training.setCustomer(customer);
    training.getCustomer().setCustomerId(customer.getCustomerId());

    this.service.save(training);
    return "redirect:/capacitacion/cliente/listar";
  }

  @GetMapping("/cliente/listar")
  public String listar(Model model) {
    Long idUsuario = (Long) model.getAttribute("usuarioId");

    model.addAttribute("listaCapacitaciones", this.service.findAllByUserId(idUsuario));
    return "views-cliente/lista_capacitaciones";
  }

  @ModelAttribute(name = "capacitacion")
  public Training capacitacion() {
    return new Training();
  }


}
