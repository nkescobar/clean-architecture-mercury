package com.makingapp.mercury.usecase;

import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.service.CategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryUseCase {
    private final CategoryService service;

    public CategoryUseCase(CategoryService service) {
        this.service = service;
    }
    public List<Category> findAllCategories() {
       return service.findAllCategories();
    }
}
