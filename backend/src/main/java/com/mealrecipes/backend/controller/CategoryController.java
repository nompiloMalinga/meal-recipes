package com.mealrecipes.backend.controller;


import com.mealrecipes.backend.ResponseDto.CategoriesResponseDto;
import com.mealrecipes.backend.ResponseDto.MealsResponseDto;
import com.mealrecipes.backend.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/meals")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

   /** TheMealDB, is a public API that provides  data about meals and recipes from around the world.
    * The Categories endpoint returns a list of all available meal categories.
    Each category represents a type of meal (e.g., Beef)
    The Search endpoint allows searching for meals by name or partial name.
    It returns a list of meals whose names contains the provided search term, rather than a single exact match.*/

    private final MealService mealService;

    public CategoryController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoriesResponseDto> getCategories(){
       CategoriesResponseDto categories = mealService.getAllCategories();
       if(categories.getCategories().isEmpty()){
           return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(categories);
       }
       return ResponseEntity.ok(categories);
   }

   @GetMapping("/search")
   public ResponseEntity<MealsResponseDto>getSpecificMeal(@RequestParam String name){
       MealsResponseDto meals = mealService.getMeals(name);

       if(meals.getMeals().isEmpty()){
           return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(meals);
       }
       return ResponseEntity.ok(meals);

   }


}
