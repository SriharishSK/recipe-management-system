package com.recipe.sriharish.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RECIPE_INGREDIENT")
public class RecipeIngredient{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relationship to Recipe
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    // Relationship to Ingredient
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal vol;

    @Column(nullable = false, length = 20)
    private String unit;

    @Column(name = "is_metric")
    private Boolean isMetric = false;

    // Constructors
    public RecipeIngredient() {}

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, BigDecimal vol, String unit, Boolean isMetric) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.vol = vol;
        this.unit = unit;
        this.isMetric = isMetric;
    }
    
     // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Recipe getRecipe() { return recipe; }
    public void setRecipe(Recipe recipe) { this.recipe = recipe; }

    public Ingredient getIngredient() { return ingredient; }
    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }

    public BigDecimal getVol() { return vol; }
    public void setVol(BigDecimal vol) { this.vol = vol; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public Boolean getIsMetric() { return isMetric; }
    public void setIsMetric(Boolean isMetric) { this.isMetric = isMetric; }
}
    

