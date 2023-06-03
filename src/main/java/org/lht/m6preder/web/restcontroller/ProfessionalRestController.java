package org.lht.m6preder.web.restcontroller;

import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.service.ProfessionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professional")
public class ProfessionalRestController {

  private final ProfessionalService service;

  public ProfessionalRestController(ProfessionalService service) {
    this.service = service;
  }
  @GetMapping("/all")
  public ResponseEntity<List<Professional>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{professionalId}")
  public ResponseEntity<Professional> findById(@PathVariable("professionalId") Long professionalId) {
    return service.findById(professionalId)
            .map(prof -> new ResponseEntity<>(prof, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Professional> save(@RequestBody Professional professional) {
    return new ResponseEntity<>(service.save(professional), HttpStatus.OK);
  }
}
