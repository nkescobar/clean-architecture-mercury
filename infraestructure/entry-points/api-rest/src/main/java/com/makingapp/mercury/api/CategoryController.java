package com.makingapp.mercury.api;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.response.model.CustomResponse;
import com.makingapp.mercury.service.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/v1")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorias")
    public ResponseEntity<CustomResponse<List<Category>>> getCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CustomResponse<Category>> getCategory(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/categorias")
    public ResponseEntity<CustomResponse<Category>> saveCategory(@RequestBody Category request) {
        return categoryService.save(request);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CustomResponse<Category>> updateCategory(@RequestBody Category request, @PathVariable Long id) {
        return categoryService.update(request, id);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<CustomResponse> eliminar(@PathVariable Long id) {
        ResponseEntity<CustomResponse> response = categoryService.delete(id);
        return response;
    }

}
