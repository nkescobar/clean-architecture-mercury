package com.makingapp.mercury.api;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.usecase.CategoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryUseCase categoryUseCase;

    @Autowired
    public CategoryController(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Category>> getCategory() {
        log.debug("Metodo categorias");
        System.out.println(" Metodo categorias = " );

        List<Category> categories = categoryUseCase.get();
        System.out.println(categories);

        ResponseEntity<List<Category>> response = new ResponseEntity<List<Category>>(categories, HttpStatus.ACCEPTED);
        return response;
    }


}
