package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.Product;
import com.Sena_Market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> getAllFilter(){return productRepository.getAllFilter();}

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Product update( int id , Product priduct  ){
        return productRepository.update( id , priduct);
    }

    public Product updateActive(int id, boolean active) {
        return productRepository.getProduct(id)
                .map(product -> {
                    product.setActive(active);  // Actualizamos solo el campo 'active'
                    return productRepository.save(product);  // Guardamos el producto actualizado
                })
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con id: " + id));
    }


}
