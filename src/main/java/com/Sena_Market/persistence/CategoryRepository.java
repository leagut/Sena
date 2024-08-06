package com.Sena_Market.persistence;

import com.Sena_Market.domain.Category;
import com.Sena_Market.persistence.crud.CategoryCrudRepository;
import com.Sena_Market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryRepository implements com.Sena_Market.domain.repository.CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Optional<Category> getById(int clientId) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(int categoryId) {

    }
}
