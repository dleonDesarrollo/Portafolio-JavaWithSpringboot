package org.lht.m6preder.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Payment;
import org.lht.m6preder.domain.service.CustomerService;
import org.lht.m6preder.domain.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/pago")
public class PagoController {

  private final PaymentService service;
  private final CustomerService customerService;

  @GetMapping("/administrativo/nuevo/{idCliente}")
  public String mostrarFormularioIngresoPago(@PathVariable(name = "idCliente") Long idCliente, Model model) {

    Customer customer = customerService.findById(idCliente).get();

    model.addAttribute("cliente", customer);


    return "views-administrativo/formulario_pagos";
  }

  @PostMapping("/administrativo/nuevo/{idCliente}")
  public String addPago(@PathVariable(name = "idCliente") Long idCliente, Payment payment) {

    Customer customer = customerService.findById(idCliente).get();
    payment.setCustomer(customer);

    log.info("Pago ingresado: {}", payment);

    this.service.save(payment);
    return "redirect:/pago/administrativo/listar";
  }

  @GetMapping("/administrativo/listar")
  public String listar(Model model) {
    model.addAttribute("listaPago", this.service.findAll());
    return "views-administrativo/lista_pagos";
  }

  @GetMapping("/administrativo/listarClientes")
  public String listarClientes(Model model) {
    model.addAttribute("listarClientes", customerService.findAll());
    return "views-administrativo/listar_clientes_pago";

  }


  @ModelAttribute(name = "pago")
  public Payment pago() {
    return new Payment();
  }

}







