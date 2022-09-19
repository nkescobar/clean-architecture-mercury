package com.makingapp.mercury.jpa.mapper;
import com.makingapp.mercury.jpa.entities.CategoryEntity;
import com.makingapp.mercury.model.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    Category toModel(CategoryEntity categoryEntity);
    CategoryEntity toEntity(CategoryEntity financialInfo);
}
