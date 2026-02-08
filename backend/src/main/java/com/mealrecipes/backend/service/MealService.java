package com.mealrecipes.backend.service;

import com.mealrecipes.backend.ResponseDto.CategoriesResponseDto;
import com.mealrecipes.backend.ResponseDto.MealsResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class MealService {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1";
    public  final Logger logger = LoggerFactory.getLogger(MealService.class);

    @Autowired
    private final RestTemplate restTemplate;

    public MealService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CategoriesResponseDto getAllCategories(){
        String url = BASE_URL +"/categories.php";

        try{

            ResponseEntity<CategoriesResponseDto> response = restTemplate.getForEntity(url, CategoriesResponseDto.class);


            CategoriesResponseDto body = Optional.ofNullable(response.getBody())
                            .orElse(new CategoriesResponseDto());

            if (body.getCategories().isEmpty()){
                logger.info("Failed to fetch categories from MealDB API" );

            }
            return  body;


        } catch (Exception e) {
            logger.error("Failed to fetch categories from MealDB API:",e);
            return new CategoriesResponseDto();
        }

    }

    public MealsResponseDto getMeals(String mealName){
        String url = BASE_URL + "/search.php?s="+mealName;

        try {

            ResponseEntity<MealsResponseDto> responseDto = restTemplate.getForEntity(url, MealsResponseDto.class);
            MealsResponseDto body = Optional.ofNullable(responseDto.getBody())
                    .orElse(new MealsResponseDto());

            if (body.getMeals().isEmpty()){
                logger.info("No meals found for search term: {}", mealName);

            }
            return  body;

        } catch (Exception e) {
            logger.error("Error calling MealDB API for search term: {}", mealName, e);
            return new MealsResponseDto();
        }
    }
}
