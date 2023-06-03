package org.lht.m6preder;

import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.ManagerService;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class M6prederApplication {

  public static void main(String[] args) {
    SpringApplication.run(M6prederApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Bean
//  CommandLineRunner run(ManagerService managerService) {
//    return args -> {
//      Role role = new Role(null, "ROLE_ADMIN");
//      List<Role> roles = new ArrayList<>();
//      roles.add(role);
//      User user = new User(null, "admin", "admin", "Admin Test", new Date(9999L), 666999, roles, null);
//      Manager manager = new Manager(null, user, "Administracion", "Mucha");
//      managerService.save(manager);
//    };
//  }
}
