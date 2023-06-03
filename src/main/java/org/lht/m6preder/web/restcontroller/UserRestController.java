package org.lht.m6preder.web.restcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body(userService.findAll());
  }

  @PostMapping("/user/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri = URI
            .create(ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/user/save")
                    .toUriString());
    log.info("USER CREATED: {}", user);
    return ResponseEntity.created(uri).body(userService.save(user));

  }

  @PostMapping("/user/test")
  public void testSave() {
    User user = new User();
  }
}
