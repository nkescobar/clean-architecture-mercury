package com.makingapp.mercury.service;

import com.makingapp.mercury.api.CategoryController;
import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.response.model.CustomResponse;
import com.makingapp.mercury.usecase.CategoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl {
    private final CategoryUseCase categoryUseCase;
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<CustomResponse<List<Category>>> findAllCategories() {
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

    @Transactional(readOnly = true)
    public ResponseEntity<CustomResponse<Category>> findById(Long id) {
        CustomResponse<Category> response = new CustomResponse();
        try {
            Category category = categoryUseCase.findById(id);
            response.setResponse(category);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al consultar la categoria");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al consultar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<CustomResponse<Category>> save(Category category) {
        CustomResponse<Category> response = new CustomResponse();
        try {
            Category categoryResponse = categoryUseCase.save(category);
            response.setResponse(categoryResponse);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al guardar la categoria");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al guardar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<CustomResponse<Category>> update(Category category, Long id) {
        CustomResponse<Category> response = new CustomResponse();
        try {
            Category categoryResponse = categoryUseCase.update(category, id);
            response.setResponse(categoryResponse);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al actualizar la categoria");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al actualizar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<CustomResponse> delete(Long id) {
        CustomResponse response = new CustomResponse();
        try {
            categoryUseCase.delete(id);
            response.setMessage("Registro eliminado.");
        } catch (Exception e) {
            response.setMessage("Error al eliminar la categoria");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al eliminar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
