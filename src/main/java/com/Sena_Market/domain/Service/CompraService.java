package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.Product;
import com.Sena_Market.domain.dto.CompraRequest;
import com.Sena_Market.persistence.ProductoRepository;
import com.Sena_Market.persistence.crud.CompraRepository;
import com.Sena_Market.persistence.entity.Compra;
import com.Sena_Market.persistence.entity.ComprasProducto;
import com.Sena_Market.persistence.entity.Producto;
import com.Sena_Market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductMapper productMapper;

    public Compra registrarCompra(CompraRequest compraRequest) {
        // Crear la entidad Compra
        Compra compra = new Compra();
        compra.setDireccion(compraRequest.getDireccion());
        compra.setNumeroFactura(compraRequest.getNumeroFactura());
        compra.setTelefono(compraRequest.getTelefono());
        compra.setTotal(compraRequest.getTotal());
        compra.setFecha(LocalDateTime.now());
        compra.setEstado("PENDIENTE"); // Estado inicial, por ejemplo

        // Crear las relaciones con CompraProducto
        List<ComprasProducto> comprasProductos = compraRequest.getPreventas().stream().map(preventa -> {
            // Validar si el producto existe utilizando tu ProductoRepository
            Optional<Product> optionalProduct = productoRepository.getProduct(preventa.getIdProducto());
            if (optionalProduct.isEmpty()) {
                throw new IllegalArgumentException("Producto con ID " + preventa.getIdProducto() + " no encontrado");
            }

            // Convertir el DTO Product a la entidad Producto
            Producto producto = productMapper.toProducto(optionalProduct.get());

            // Crear la entidad ComprasProducto
            ComprasProducto comprasProducto = new ComprasProducto();
            comprasProducto.setProducto(producto); // Usar la entidad Producto
            comprasProducto.setPrecio(preventa.getPrecio());
            comprasProducto.setEstado(true); // Estado inicial, por ejemplo
            comprasProducto.setCompra(compra); // Relacionar con la compra actual

            return comprasProducto;
        }).collect(Collectors.toList());

        // Establecer los productos en la compra
        compra.setProductos(comprasProductos);

        // Guardar la compra con sus productos (gracias a CascadeType.ALL)
        return compraRepository.save(compra);
    }
    }















