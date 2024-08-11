package com.Sena_Market.persistence.mapper;

import com.Sena_Market.domain.User;
import com.Sena_Market.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "nombre"  , target = "name"),
            @Mapping(source = "correo"  , target = "email"),
            @Mapping(source = "telefono"  , target = "phone"),
            @Mapping(source = "perfil"  , target = "profile")
    })
    User toUser(Usuario usuario);

    List<User>toUsers(List<Usuario> usuarios );

    @InheritInverseConfiguration
    @Mapping(target = "contrasena" , ignore = true)
    Usuario toUsuario (User user);



}
