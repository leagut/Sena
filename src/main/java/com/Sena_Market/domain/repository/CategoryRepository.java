package com.Sena_Market.domain.repository;

import com.Sena_Market.domain.Category;
import com.Sena_Market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category>getAll();
    Optional<Category>getById(int clientId);
    Category save(Category category);
    void delete(int categoryId);
}
