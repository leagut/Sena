package com.Sena_Market.persistence.crud;

import com.Sena_Market.persistence.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query(value = """
        SELECT 
            p.nombre AS nombreProducto, 
            YEAR(s.fecha) AS anio, 
            MONTH(s.fecha) AS mes, 
            COUNT(s.id) AS cantidadVendida
        FROM 
            stock s
        JOIN 
            productos p ON s.id_producto = p.id_producto
        GROUP BY 
            p.nombre, YEAR(s.fecha), MONTH(s.fecha)
        ORDER BY 
            anio, mes
        """, nativeQuery = true)
    List<Object[]> getCantidadVendidaPorMes();
}
