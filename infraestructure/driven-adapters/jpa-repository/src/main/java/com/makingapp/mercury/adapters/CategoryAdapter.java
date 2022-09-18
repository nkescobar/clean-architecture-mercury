package com.makingapp.mercury.adapters;

import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.mapper.CategoryMapper;
import com.makingapp.mercury.model.CategoryEntity;
import com.makingapp.mercury.repository.CategoryRepository;
import com.makingapp.mercury.usecase.CategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryAdapter implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryMapper.toModel((CategoryEntity) categoryRepository.findAll());
    }
}
