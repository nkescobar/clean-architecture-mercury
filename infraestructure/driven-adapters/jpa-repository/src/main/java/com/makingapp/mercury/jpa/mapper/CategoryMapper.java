package com.makingapp.mercury.jpa.mapper;
import com.makingapp.mercury.jpa.entities.CategoryEntity;
import com.makingapp.mercury.model.Category;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CategoryMapper {

    Category toModel(CategoryEntity categoryEntity);

    CategoryEntity toEntity(Category category);


    default List<CategoryEntity> listModelToEntity(List<Category> categories) {
        return categories.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<Category> listEntityToModel(
            List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
