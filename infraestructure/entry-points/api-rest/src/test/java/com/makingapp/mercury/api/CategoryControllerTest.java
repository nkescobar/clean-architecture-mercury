package com.makingapp.mercury.api;

import com.makingapp.mercury.model.Category;
import com.makingapp.mercury.response.model.CustomResponse;
import com.makingapp.mercury.service.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveCategoryTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Category category = new Category(Long.valueOf(1),"Clasicos", "Libros de literatura");
        when(categoryService.save(any(Category.class)))
                .thenReturn(new ResponseEntity<CustomResponse<Category>>(HttpStatus.OK));
        ResponseEntity<CustomResponse<Category>> response = categoryController.saveCategory(category);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);

    }
}
