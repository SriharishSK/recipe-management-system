package com.recipe.sriharish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.sriharish.dao.IngredientRepository;
import com.recipe.sriharish.dao.RecipeRepository;
import com.recipe.sriharish.model.Ingredient;
import com.recipe.sriharish.model.Recipe;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;


    // Add new ingredient
    public Ingredient addIngredientToRecipe(Integer recipeId, String name, String quantity) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setQuantity(quantity);
        ingredient.setRecipe(recipe);
        return ingredientRepository.save(ingredient);
    }

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

