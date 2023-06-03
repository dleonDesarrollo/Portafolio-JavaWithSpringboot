package org.lht.m6preder.domain.service;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.domain.dto.Professional;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.repository.ProfessionalRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalService {

  private final ProfessionalRepository repo;
  private final PasswordEncoder passwordEncoder;


  public List<Professional> findAll() {
    return repo.findAll();
  }

  public Optional<Professional> findById(Long professionalId) {
    return repo.findById(professionalId);
  }

  public Professional save(Professional professional) {
    User userOfProfessional = professional.getUser();

    userOfProfessional.setPassword(passwordEncoder.encode(userOfProfessional.getPassword()));

    return repo.save(professional);
  }

  public boolean delete(Long professionalId) {
    return findById(professionalId)
            .map(prof -> {
              repo.delete(professionalId);
              return true;
            }).orElse(false);
  }

  public Optional<Professional> findByUserId(Long userId){
    return repo.getByUsuario_IdUsuario(userId);
  }
}
