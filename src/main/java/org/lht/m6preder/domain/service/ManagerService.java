package org.lht.m6preder.domain.service;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.domain.dto.Manager;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.repository.ManagerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

  private final ManagerRepository repo;
  private final PasswordEncoder passwordEncoder;

  public List<Manager> findAll() {
    return repo.findAll();
  }

  public Optional<Manager> findById(Long managerId) {
    return repo.findById(managerId);
  }

  public Manager save(Manager manager) {
    User userOfManager = manager.getUser();

    userOfManager.setPassword(passwordEncoder.encode(userOfManager.getPassword()));

    return repo.save(manager);
  }

  public boolean delete(Long managerId) {
    return findById(managerId)
            .map(manager -> {
              repo.delete(managerId);
              return true;
            }).orElse(false);
  }

  public Optional<Manager> findByUserId(Long userId){
    return repo.getByUsuario_IdUsuario(userId);
  }
}
