package com.recipe.sriharish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipe.sriharish.dao.RecipeRepository;
import com.recipe.sriharish.model.Recipe;
import com.recipe.sriharish.model.RecipeIngredient;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // Add a new recipe
    public Recipe addRecipe(Recipe recipe) {
        // Ensure RecipeIngredients point back to this Recipe
        if (recipe.getRecipeIngredients() != null) {
            for (RecipeIngredient ri : recipe.getRecipeIngredients()) {
                ri.setRecipe(recipe);
            }
        }
        return recipeRepository.save(recipe);
    }

    // Get all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Get recipe by ID
    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id).orElse(null);
    }

    // Update recipe including ingredients
    public Recipe updateRecipe(int id, Recipe updatedRecipe) {
        return recipeRepository.findById(id).map(recipe -> {
            recipe.setName(updatedRecipe.getName());
            recipe.setInstructions(updatedRecipe.getInstructions());
            
            // Handle recipeIngredients
            recipe.getRecipeIngredients().clear();  // remove old ingredients
            if (updatedRecipe.getRecipeIngredients() != null) {
                for (RecipeIngredient ri : updatedRecipe.getRecipeIngredients()) {
                    ri.setRecipe(recipe);  // point back to recipe
                    recipe.getRecipeIngredients().add(ri);
                }
            }

            recipe.setChef(updatedRecipe.getChef());
            return recipeRepository.save(recipe);
        }).orElse(null);
    }

    // Delete recipe
    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}
