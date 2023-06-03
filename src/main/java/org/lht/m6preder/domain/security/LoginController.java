package org.lht.m6preder.domain.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final AuthenticationManager manager;
  private final JWTUtil util;
  private final UserService service;


  @GetMapping
  public String mostrarLogIn() {
    return "views-general/login";
  }


}
