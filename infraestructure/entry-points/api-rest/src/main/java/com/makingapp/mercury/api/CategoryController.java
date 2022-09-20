package com.makingapp.mercury.api;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.response.model.CustomResponse;
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
    public ResponseEntity<CustomResponse<List<Category>>> getCategory() {
        CustomResponse<List<Category>> response = new CustomResponse();
        try {
            List<Category> categories = categoryUseCase.findAllCategories();
            response.setResponse(categories);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al consultar categorias");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al consultar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
