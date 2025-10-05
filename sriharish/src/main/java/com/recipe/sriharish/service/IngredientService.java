package com.recipe.sriharish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.sriharish.dao.IngredientRepository;
import com.recipe.sriharish.model.Ingredient;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Add new ingredient
    

    public List<Ingredient> addAllIngredients(List<Ingredient> ingredients) {
    return ingredientRepository.saveAll(ingredients);
}


    // Get all ingredients
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Get ingredient by ID
    public Ingredient getIngredientById(int id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    // Update ingredient
    public Ingredient updateIngredient(int id, Ingredient updatedIngredient) {
        return ingredientRepository.findById(id).map(ingredient -> {
            ingredient.setName(updatedIngredient.getName());
            return ingredientRepository.save(ingredient);
        }).orElse(null);
    }


    // Delete ingredient
    public void deleteIngredient(int id) {
        ingredientRepository.deleteById(id);
    }
}

