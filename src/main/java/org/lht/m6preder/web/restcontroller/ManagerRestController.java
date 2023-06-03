package org.lht.m6preder.web.restcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Customer;
import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.ManagerService;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerRestController {

  private final ManagerService managerService;


  @PostMapping("/save")
  public ResponseEntity<Manager> save(@RequestBody Manager manager) {
    return new ResponseEntity<>(managerService.save(manager), HttpStatus.OK);
  }

}
