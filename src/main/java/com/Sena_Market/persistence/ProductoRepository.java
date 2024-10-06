package com.Sena_Market.persistence;

import com.Sena_Market.domain.Product;
import com.Sena_Market.domain.repository.ProductRepository;
import com.Sena_Market.persistence.crud.ProductoCrudRepository;
import com.Sena_Market.persistence.entity.Producto;
import com.Sena_Market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> getAll()
    {
        List<Producto>productos= (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);

    }

    @Override
    public List<Product> getAllFilter() {
        List<Producto>productos=(List<Producto>) productoCrudRepository.findByEstadoTrueAndCategoriaEstadoTrue();
        return  mapper.toProducts(productos) ;
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto>productos =  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity , true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));

    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    public Product update(int productId, Product updatedProduct) {
        return productoCrudRepository.findById(productId).map(product -> {
            product.setNombre(updatedProduct.getName());
            product.setPrecioVenta(updatedProduct.getPrice());
            product.setCantidadStock(updatedProduct.getStock());

            Producto savedProducto = productoCrudRepository.save(product);

            return mapper.toProduct(savedProducto);

        }).orElseThrow(() -> new NoSuchElementException("Producto no encontrado con id: " + productId));
    }


}
