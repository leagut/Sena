package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Categoria;
import com.Sena_Market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategoryCrudRepository extends CrudRepository <Categoria,Integer> {

    //List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock , boolean estado);
}
