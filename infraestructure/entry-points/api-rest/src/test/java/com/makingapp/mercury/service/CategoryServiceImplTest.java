package com.makingapp.mercury.service;


import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.response.model.CustomResponse;
import com.makingapp.mercury.usecase.CategoryUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class CategoryServiceImplTest {

    @InjectMocks
    CategoryServiceImpl service;

    @Mock
    CategoryUseCase categoryUseCase;

    List<Category> list = new ArrayList<Category>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.loadCategories();
    }

    @Test
    public void shouldFindCategoriesTest() {
        when(categoryUseCase.findAllCategories()).thenReturn(list);
        ResponseEntity<CustomResponse<List<Category>>> response = service.findAllCategories();
        assertEquals(4,response.getBody().getResponse().size());
        verify(categoryUseCase, times(1)).findAllCategories();

    }

    public void loadCategories() {
        list.add(new Category(Long.valueOf(1), "Romantica","Novelas romanticas"));
        list.add(new Category(Long.valueOf(2), "Accion"," Temas de accion"));
        list.add(new Category(Long.valueOf(3), "Infantil","Temas infantiles"));
        list.add(new Category(Long.valueOf(4), "Ciencia","Temas de ciencia"));
    }
}
