package org.lht.m6preder.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.domain.dto.User;
import org.lht.m6preder.domain.repository.UserRepository;
import org.lht.m6preder.persistence.crud.UsuarioCrudRepository;
import org.lht.m6preder.persistence.entity.Usuario;
import org.lht.m6preder.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsuarioRepository implements UserRepository {

  private final UsuarioCrudRepository crud;
  private final UserMapper mapper;

  @Override
  public List<User> findAll() {
    return mapper.toUsers((List<Usuario>) crud.findAll());
  }

  @Override
  public Optional<User> findById(Long userId) {
    return crud
            .findById(userId)
            .map(mapper::toUser);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return crud.findByNombreUsuario(username)
            .map(mapper::toUser);
  }

  @Override
  public User save(User user) {
    return mapper.toUser(crud.save(mapper.toUsuario(user)));
  }

  @Override
  public void delete(Long userId) {
    crud.deleteById(userId);

  }


  @Override
  public boolean existsByUsername(String username) {
    return crud.existsByNombreUsuario(username);
  }
}
