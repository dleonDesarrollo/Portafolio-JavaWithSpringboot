package org.lht.m6preder.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lht.m6preder.domain.dto.Role;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.repository.RoleRepository;
import org.lht.m6preder.domain.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
    log.info("ROLES EN USUARIO CARGADO: {}", user.getTheRoles());
    return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            mapperRoles((List<Role>) user.getTheRoles())
    );
  }


  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findById(Long userId) {
    return userRepository.findById(userId);
  }

  public Optional<User> findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public Role save(Role role) {
    return roleRepository.save(role);
  }

  public boolean delete(Long userId) {
    return findById(userId)
            .map(user -> {
              userRepository.delete(userId);
              return true;
            }).orElse(false);
  }

  private Collection<? extends GrantedAuthority> mapperRoles(List<Role> theRoles) {
    return theRoles.stream()
            .map(rol -> new SimpleGrantedAuthority(rol.getName()))
            .collect(Collectors.toList());
  }


}
