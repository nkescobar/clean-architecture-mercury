package com.makingapp.mercury.jpa.adapters;

import com.makingapp.mercury.jpa.entities.CategoryEntity;
import com.makingapp.mercury.jpa.repository.CategoryRepository;
import com.makingapp.mercury.service.CategoryService;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.jpa.mapper.CategoryMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return this.categoryMapper.listEntityToModel(
                categoryRepository.findAll());
    }
}
