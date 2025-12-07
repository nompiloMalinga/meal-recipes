package com.mealrecipes.backend.service;

import com.mealrecipes.backend.ResponseDto.CategoriesResponseDto;
import com.mealrecipes.backend.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MealService mealService;

    @Test
    void getAllCategories_shouldReturnCategories(){

        CategoriesResponseDto mockedResponse = new CategoriesResponseDto(List.of
                (new CategoryDto("1","beef","pictures",
                        "Beef is the culinary name for meat from cattle")
                ,new CategoryDto("2","lamb","pictures",
                        "Lamb, hogget, and mutton are the meat of domestic sheep ")));

        ResponseEntity<CategoriesResponseDto> responseEntity = new ResponseEntity<>(mockedResponse, HttpStatus.OK);

        when(restTemplate.getForEntity("https://www.themealdb.com/api/json/v1/1/categories.php", CategoriesResponseDto.class))
                .thenReturn(responseEntity);

        CategoriesResponseDto response = mealService.getAllCategories();
        assertNotNull(response);
        assertEquals(2,response.getCategories().size());
        assertEquals("lamb",response.getCategories().get(1).getStrCategory());




    }
    @Test
    void testGetAllCategories_EmptyBody_ReturnsEmptyList() {

        CategoriesResponseDto responseDto = new CategoriesResponseDto(new ArrayList<>());
        ResponseEntity<CategoriesResponseDto> responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);

        when(restTemplate.getForEntity("https://www.themealdb.com/api/json/v1/1/categories.php", CategoriesResponseDto.class))
                .thenReturn(responseEntity);

        CategoriesResponseDto result = mealService.getAllCategories();

        assertTrue(result.getCategories().isEmpty());
    }


}