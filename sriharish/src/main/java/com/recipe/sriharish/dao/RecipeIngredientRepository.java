package com.recipe.sriharish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.sriharish.model.RecipeIngredient;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

    // Find all ingredients for a specific recipe
    List<RecipeIngredient> findByRecipeId(int recipeId);

    // Optional: find all RecipeIngredient entries for a specific ingredient
    List<RecipeIngredient> findByIngredientId(int ingredientId);
}
