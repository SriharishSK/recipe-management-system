package com.recipe.sriharish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recipe.sriharish.model.Ingredient;
import com.recipe.sriharish.service.IngredientService;
import java.util.List;

@RestController
@RequestMapping("/ingredients")  // Base URL for ingredients
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Add new ingredient
    @PostMapping("/add")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    // Get all ingredients
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    // Get ingredient by ID
    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable int id) {
        return ingredientService.getIngredientById(id);
    }

    // Update ingredient
    @PutMapping("/update/{id}")
    public Ingredient updateIngredient(@PathVariable int id, @RequestBody Ingredient updatedIngredient) {
        return ingredientService.updateIngredient(id, updatedIngredient);
    }

    // Delete ingredient
    @DeleteMapping("/{id}")
    public String deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
        return "Ingredient deleted successfully";
    }
}
