package com.makingapp.mercury.service;

import com.makingapp.mercury.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategories();
    public Category findById(Long id);
    public Category save(Category category);
    public Category update(Category category, Long id);

    public void delete( Long id);


}
