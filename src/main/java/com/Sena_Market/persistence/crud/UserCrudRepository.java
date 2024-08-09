package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository< Usuario, Integer> {

}
