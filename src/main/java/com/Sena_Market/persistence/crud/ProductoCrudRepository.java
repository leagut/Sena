package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    List<Producto> findByEstadoTrueAndCategoriaEstadoTrue();

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock , boolean estado);
}
