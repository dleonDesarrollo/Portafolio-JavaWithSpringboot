package org.lht.m6preder.persistence.crud;

import org.lht.m6preder.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {

  Optional<Usuario> findByNombreUsuario(String username);
  boolean existsByNombreUsuario(String username);

}
