package com.Sena_Market.persistence;

import com.Sena_Market.domain.User;
import com.Sena_Market.domain.repository.UserRepository;
import com.Sena_Market.persistence.crud.UserCrudRepository;
import com.Sena_Market.persistence.entity.Usuario;
import com.Sena_Market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Usuario> getAll() {

       Iterable<Usuario> iterableUsuarios = userCrudRepository.findAll();
       List<Usuario> listaUsuarios = new ArrayList<>();
        iterableUsuarios.forEach(listaUsuarios::add);
        return listaUsuarios;

    }

    @Override
    public Optional<Usuario> getById(int usuarioId) {
        return userCrudRepository.findById(usuarioId);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return userCrudRepository.save(usuario);
    }

    @Override
    public boolean delete(int usuarioId) {
        if (userCrudRepository.existsById(usuarioId)) {
            userCrudRepository.deleteById(usuarioId);
            return true; // Si se eliminó correctamente, devuelve true
        }
        return false; // Si no se encontró el usuario, devuelve false
    }

    @Override
    public Optional<User> getUser(String correo, String contrasena) {
        return userCrudRepository
                .findByCorreoAndContrasena(correo, contrasena)
                .map(userMapper::toUser); // Usamos la referencia directa al método
    }


}
