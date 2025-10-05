package com.recipe.sriharish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recipe.sriharish.model.Recipe;
import com.recipe.sriharish.service.RecipeService;
import java.util.List;

@RestController
@RequestMapping("/recipes")  // Base URL for recipes
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Add a new recipe
    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    // Get all recipes
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // Get recipe by ID
    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }

    // Update recipe (including ingredients)
    @PutMapping("/update/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe updatedRecipe) {
        return recipeService.updateRecipe(id, updatedRecipe);
    }

    // Delete recipe
    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return "Recipe deleted successfully";
    }
}
