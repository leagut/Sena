package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Product;
import com.Sena_Market.domain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>>getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/allfilter")
    public ResponseEntity <List<Product>>getAllFilter(){
        return new ResponseEntity<>(productService.getAllFilter(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct( @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory( @PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products , HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save( @RequestBody Product product) {
        return new ResponseEntity<>( productService.save(product) , HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete( @PathVariable("id") int productId){
        if (productService.delete(productId)){
            return  new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Product product){
        try {
            Product updatedProduct = productService.update(id, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Si no se encuentra el producto, devolvemos un error 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Cualquier otro error, devolvemos un error genérico 500
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/edit/active/{id}")
    public ResponseEntity<Product> updateActive(@PathVariable("id") int id, @RequestBody Map<String, Object> updates) {
        if (updates.containsKey("active")) {
            boolean active = (Boolean) updates.get("active");
            try {
                Product updatedProduct = productService.updateActive(id, active);
                return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Si no se pasa el campo 'active', devolvemos un error 400
        }
    }


}
