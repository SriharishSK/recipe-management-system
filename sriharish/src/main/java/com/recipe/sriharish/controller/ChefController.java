package com.recipe.sriharish.controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import com.recipe.sriharish.model.Chef;
import com.recipe.sriharish.model.Recipe;
import com.recipe.sriharish.service.ChefService;
import com.recipe.sriharish.service.IngredientService;
import com.recipe.sriharish.service.RecipeService;

import jakarta.servlet.http.HttpSession;




@Controller
@RequestMapping("/chef")
public class ChefController {

    @Autowired
    private ChefService chefService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model , HttpSession session) {
        boolean valid = chefService.authenticateChef(username, password);
        if (valid) {
            session.setAttribute("loggedInUsername", username);
            return "redirect:/chef/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

    @PostMapping("/register")
    public String registerChef(@ModelAttribute Chef chef, Model model) {
            if (chefService.existsByEmail(chef.getEmail())) {
        model.addAttribute("error", "Email already registered!");
        return "register"; // stay on the same page and show error
    }
        chefService.registerChef(chef);
        model.addAttribute("success", "Registration successful!");
        return "redirect:/chef/login";
    }


     @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
    String username = (String) session.getAttribute("loggedInUsername");
    Chef chef = chefService.findByUsername(username);  // or by email if you prefer
    List<Recipe> recipes = recipeService.getRecipesByChef(chef);

    model.addAttribute("chef", chef);
    model.addAttribute("recipes", recipes);
    return "chef-dashboard";
}

    
       @PostMapping("/add-recipe")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        Chef chef = chefService.getLoggedInChef();
        recipe.setChef(chef);
        recipeService.saveRecipe(recipe);
        return "redirect:/chef/dashboard";
    }

      // Add Ingredient to a Recipe
    @PostMapping("/add-ingredient/{recipeId}")
    public String addIngredient(@PathVariable Long recipeId,
                                @RequestParam String name,
                                @RequestParam String quantity) {
        ingredientService.addIngredientToRecipe(recipeId.intValue(), name, quantity);
        return "redirect:/chef/dashboard";
    }

    // Delete Recipe
    @PostMapping("/delete-recipe/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id.intValue());
        return "redirect:/chef/dashboard";
    }

}
