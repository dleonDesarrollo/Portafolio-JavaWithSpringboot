package org.lht.m6preder.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/resumen")
@RequiredArgsConstructor
public class ResumenController {

  private final TrainingService trainingService;
  private final InspectionService inspectionService;
  private final PaymentService paymentService;
  private final CustomerService customerService;
  private final ManagerService managerService;
  private final ProfessionalService professionalService;
  private final UserService userService;
  private final ChecklistService checklistService;


  @GetMapping("/cliente")
  public String getResumenCliente(Model model) {
    Long idUsuario = (Long) model.getAttribute("usuarioId");
    Long idCliente = (Long) model.getAttribute("idForRole");
    Random random = new Random();

    int capasSolicitadas = this.trainingService.findAllByUserId(idUsuario).size();
    int visitasAsociadas = this.inspectionService.findAllByCustomer(idCliente).size();
    int pagosAsociados = this.paymentService.findAllByCustomer(idCliente).size();
    int cantidadAccidentes = random.nextInt(25) + 1;

    model.addAttribute("capasSolicitadas", capasSolicitadas);
    model.addAttribute("visitasAsociadas", visitasAsociadas);
    model.addAttribute("pagosAsociados", pagosAsociados);
    model.addAttribute("cantidadAccidentes", cantidadAccidentes);
    return "views-cliente/resumen_cliente";
  }

  @GetMapping("/administrativo")
  public String getResumenAdmin(Model model) {
    Long idUsuario = (Long) model.getAttribute("usuarioId");
    Long idAdmin = (Long) model.getAttribute("idForRole");
    Random random = new Random();

    int cantidadUser = this.userService.findAll().size();
    int cantidadPagos = this.paymentService.findAll().size();
    int cantidadRevisiones = this.paymentService.findAll().size();
    int cantidadSolicitudes = random.nextInt(87) + 1;

    model.addAttribute("cantidadUser", cantidadUser);
    model.addAttribute("cantidadPagos", cantidadPagos);
    model.addAttribute("cantidadRevisiones", cantidadRevisiones);
    model.addAttribute("cantidadSolicitudes", cantidadSolicitudes);

    return "views-administrativo/resumen_administrativo";
  }

  @GetMapping("/profesional")
  public String getResumenProfe(Model model) {
    Long idUsuario = (Long) model.getAttribute("usuarioId");
    Long idProfe = (Long) model.getAttribute("idForRole");
    Random random = new Random();

    int cantidadVisitas = this.inspectionService.findAllByUserId(idUsuario).size();
    int cantidadRevisiones = this.checklistService.findAllByProfessionalId(idProfe).size();
    int cantidadAsesorias = random.nextInt(15) + 1;
    int cantidadClientes = random.nextInt(87) + 1;

    model.addAttribute("cantidadVisitas", cantidadVisitas);
    model.addAttribute("cantidadRevisiones", cantidadRevisiones);
    model.addAttribute("cantidadAsesorias", cantidadAsesorias);
    model.addAttribute("cantidadClientes", cantidadClientes);

    return "views-profesional/resumen_profesional";
  }

}
