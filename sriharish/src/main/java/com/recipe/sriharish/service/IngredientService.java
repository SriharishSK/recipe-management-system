package com.recipe.sriharish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipe.sriharish.dao.IngredientRepository;
import com.recipe.sriharish.model.Ingredient;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Add new ingredient
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
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

