package com.Sena_Market.persistence;

import com.Sena_Market.domain.Category;
import com.Sena_Market.domain.repository.CategoryRepository;
import com.Sena_Market.persistence.crud.CategoryCrudRepository;
import com.Sena_Market.persistence.entity.Categoria;
import com.Sena_Market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        return  mapper.toCategories((List<Categoria>) categoryCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getById(int category) {
        return categoryCrudRepository.findById(category).map(x -> mapper.toCategory(x));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return  mapper.toCategory(categoryCrudRepository.save(categoria));
    }

    @Override
    public Optional<Category> delete(int categoryId) {
        return categoryCrudRepository.findById(categoryId).map(categoria -> {
            categoria.setEstado(false);
            return Optional.of(save(mapper.toCategory(categoria)));
        }).orElse(Optional.empty());
    }


}
