package com.Sena_Market.domain.repository;


import com.Sena_Market.domain.User;
import com.Sena_Market.persistence.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<Usuario>getAll();
    Optional<Usuario>getById(int usuarioId);
    Usuario save(Usuario usuario);
    boolean delete(int usuarioId);
    Optional<User> getUser(String correo , String contrasena);

}
