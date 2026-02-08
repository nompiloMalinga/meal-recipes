package com.mealrecipes.backend.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mealrecipes.backend.dto.MealDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MealsResponseDto {

    @JsonProperty("meals")
    private List<MealDto> meals = new ArrayList<>();

    public  MealsResponseDto(){}

    public MealsResponseDto(List<MealDto> meals) {
        this.meals = meals != null ? meals: new ArrayList<>();
    }

    public List<MealDto> getMeals() {
        return Collections.unmodifiableList(meals);
    }

    public void setMeals(List<MealDto> meals) {
        this.meals = meals !=null ? meals : new ArrayList<>();
    }
}
