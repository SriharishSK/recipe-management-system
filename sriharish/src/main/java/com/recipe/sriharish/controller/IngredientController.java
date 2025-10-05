package com.recipe.sriharish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.sriharish.model.Ingredient;
import com.recipe.sriharish.service.IngredientService;

@RestController
@RequestMapping("/ingredients")  // Base URL for ingredients
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Add new ingredient
   
@PostMapping("/add")
public List<Ingredient> addIngredients(@RequestBody List<Ingredient> ingredients) {
    return ingredientService.addAllIngredients(ingredients);
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
