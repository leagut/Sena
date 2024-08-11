package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserCrudRepository extends JpaRepository< Usuario, Integer> {
    public Optional<Usuario>  findByCorreoAndContrasena(String correo , String contrasena);
}
