package com.mealrecipes.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealDto {
    @JsonProperty("idMeal")
    private String idMeal;
    @JsonProperty("strMeal")
    private String strMeal;
    @JsonProperty("strCategory")
    private String strCategory;
    @JsonProperty("strArea")
    private String strArea;
    @JsonProperty("strInstructions")
    private String strInstructions;
    @JsonProperty("strMealThumb")
    private String strMealThumb;
    @JsonProperty("strYoutube")
    private String strYoutube;
    @JsonProperty("strSource")
    private String strSource;

    public MealDto() {

    }

    public MealDto(String idMeal, String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strYoutube, String strSource) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strYoutube = strYoutube;
        this.strSource = strSource;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }
}
