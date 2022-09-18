package com.makingapp.mercury.mapper;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.model.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryEntity toModel(CategoryEntity categoryEntity);
    CategoryEntity toEntity(CategoryEntity financialInfo);
}
