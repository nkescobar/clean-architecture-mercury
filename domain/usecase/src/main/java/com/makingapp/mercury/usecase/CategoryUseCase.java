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
    public Category findById(Long id) {
        return service.findById(id);
    }
    public Category save(Category category) {
        return service.save(category);
    }
    public Category update(Category category, Long id) {
        return service.update(category, id);
    }
    public void delete( Long id) {
       service.delete(id);
    }


}
