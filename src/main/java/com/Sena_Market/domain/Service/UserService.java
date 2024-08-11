package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.Category;
import com.Sena_Market.domain.User;
import com.Sena_Market.domain.repository.UserRepository;
import com.Sena_Market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Usuario> getAll(){
        return userRepository.getAll();
    }

    public Optional<Usuario> getById(int categoria){
        return userRepository.getById(categoria);
    }

    public Usuario save(Usuario categoria){
        return userRepository.save(categoria);
    }

    public boolean delete(int categoryId) {
         return  userRepository.delete(categoryId);
    }

    public Optional<User>getUser(String correo, String contrasena){
        return userRepository.getUser(correo,contrasena);
    }

}
