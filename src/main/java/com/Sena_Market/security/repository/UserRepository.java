package com.Sena_Market.security.repository;

import com.Sena_Market.security.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

    public interface UserRepository extends CrudRepository<UserEntity, Long> {
        Optional<UserEntity> findUserEntityByUsername(String username);
    }