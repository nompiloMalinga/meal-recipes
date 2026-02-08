package com.mealrecipes.backend.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mealrecipes.backend.dto.CategoryDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriesResponseDto {


    @JsonProperty("categories")
    private List<CategoryDto>categories = new ArrayList<>();

    public CategoriesResponseDto(){}
    public CategoriesResponseDto(List<CategoryDto> categories) {

        this.categories = categories != null ? categories : new ArrayList<>();
    }


    public List<CategoryDto> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void setCategories(List<CategoryDto> categories) {

        this.categories = categories !=null ? categories : new ArrayList<>();
    }
}
