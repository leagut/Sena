package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.Category;
import com.Sena_Market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category>getById(int categoria){
        return categoryRepository.getById(categoria);
    }

    public Category save(Category categoria){
        return categoryRepository.save(categoria);
    }
    public Optional<Category> delete(int categoryId) {
        return  categoryRepository.delete((categoryId));
    }



}
