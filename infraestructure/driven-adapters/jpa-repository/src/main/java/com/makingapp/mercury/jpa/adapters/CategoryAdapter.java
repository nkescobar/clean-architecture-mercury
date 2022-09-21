package com.makingapp.mercury.jpa.adapters;

import com.makingapp.mercury.jpa.entities.CategoryEntity;
import com.makingapp.mercury.jpa.repository.CategoryRepository;
import com.makingapp.mercury.service.CategoryService;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.jpa.mapper.CategoryMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Category findById(Long id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return this.categoryMapper.toModel(category.get());
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        return this.categoryMapper.toModel(categoryRepository.save(this.categoryMapper.toEntity(category)));
    }

    @Override
    public Category update(Category category, Long id) {
        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);
        if (foundCategory.isPresent()) {
            foundCategory.get().setNombre(category.getNombre());
            foundCategory.get().setDescripcion(category.getDescripcion());
            return this.categoryMapper.toModel(categoryRepository.save(foundCategory.get()));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);
        if (foundCategory.isPresent()) {
            categoryRepository.delete(foundCategory.get());
        }
    }

}
