package com.Sena_Market.persistence.crud;

import com.Sena_Market.domain.dto.ProductoNombreDTO;
import com.Sena_Market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository2 extends JpaRepository<Producto, Integer> {

    @Query(value = "CALL sp_getLowStockProducts()", nativeQuery = true)
    List<Object[]> getLowStockProducts();

    default List<ProductoNombreDTO> getLowStockProductsDTO() {
        List<Object[]> results = getLowStockProducts();
        return results.stream()
                .map(r -> new ProductoNombreDTO((String) r[0])) // Mapear el primer campo como String
                .toList();
    }
}
