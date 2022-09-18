package com.makingapp.mercury.usecase;

import com.makingapp.mercury.model.Category;

import java.util.List;

public class CategoryUseCase {

    private final CategoryService service;


    public CategoryUseCase(CategoryService service) {
        this.service = service;
    }

    public List<Category> get() {
       return service.findAllCategories();
    }
}
