package com.mealrecipes.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mealrecipes.backend.ResponseDto.CategoriesResponseDto;
import com.mealrecipes.backend.dto.CategoryDto;
import com.mealrecipes.backend.service.MealService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private MealService mealService;

    @Test
    public void shouldReturn_mealCategories() throws Exception {

        CategoriesResponseDto mockedResponse = new CategoriesResponseDto(List.of
                (new CategoryDto("1","beef","pictures",
                                "Beef is the culinary name for meat from cattle")
                        ,new CategoryDto("2","lamb","pictures",
                                "Lamb, hogget, and mutton are the meat of domestic sheep ")));

        Mockito.when(mealService.getAllCategories()).thenReturn(mockedResponse);

        mockMvc.perform(get("/api/meals/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories[0].strCategory", is("beef")));

    }

    @Test
    public void getCategories_ReturnsServiceUnavailable_WhenCategoriesEmpty() throws Exception {

        CategoriesResponseDto responseDto = new CategoriesResponseDto(new ArrayList<>());

        Mockito.when(mealService.getAllCategories())
                .thenReturn(responseDto);

        mockMvc.perform(get("/api/meals/categories").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isServiceUnavailable())
                .andExpect(jsonPath("$.categories").isEmpty());
    }


}