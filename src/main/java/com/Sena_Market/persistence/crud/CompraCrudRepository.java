package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra , Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
