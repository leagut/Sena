package com.Sena_Market.web.controller;

import com.Sena_Market.domain.dto.ProductoNombreDTO;
import com.Sena_Market.persistence.crud.ProductoRepository2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository2 productoRepository;

    public ProductoController(ProductoRepository2 productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/low-stock")
    public List<ProductoNombreDTO> getProductosBajoInventario() {
        return productoRepository.getLowStockProductsDTO();
    }
}