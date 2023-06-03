package org.lht.m6preder.web.restcontroller;

import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

  private final CustomerService service;

  public CustomerRestController(CustomerService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Customer>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<Customer> findById(@PathVariable("customerId") Long customerId) {
    return service.findById((customerId))
            .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return new ResponseEntity<>(service.save(customer), HttpStatus.OK);
  }

  @DeleteMapping("/del/{customerId}")
  public ResponseEntity delete(@PathVariable("customerId") Long customerId) {
    return service.delete(customerId) ?
            new ResponseEntity(HttpStatus.OK) :
            new ResponseEntity(HttpStatus.NOT_FOUND);
  }
}









