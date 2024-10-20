package com.Sena_Market.persistence.mapper;

import com.Sena_Market.domain.Category;
import com.Sena_Market.domain.Product;
import com.Sena_Market.persistence.entity.Categoria;
import com.Sena_Market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping( source = "idCategoria" , target = "categoryId" ),
            @Mapping( source = "descripcion", target = "category"),
            @Mapping( source = "estado", target = "active")
    })

    Category toCategory (Categoria categoria);

    List<Category> toCategories(List<Categoria> categorias);


    @InheritInverseConfiguration
    @Mapping(target = "productos" , ignore = true )
    Categoria toCategoria (Category category);

}
