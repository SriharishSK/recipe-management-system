package com.recipe.sriharish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recipe.sriharish.model.Chef;
import com.recipe.sriharish.service.ChefService;
import java.util.List;

@RestController
@RequestMapping("/chefs")  // Base URL
public class ChefController {

    @Autowired
    private ChefService chefService;

    // Register a new chef
    @PostMapping("/register")
    public Chef registerChef(@RequestBody Chef chef) {
        return chefService.registerChef(chef);
    }

    // Login chef
    @PostMapping("/login")
    public boolean loginChef(@RequestParam String username, @RequestParam String password) {
        return chefService.authenticateChef(username, password);
    }

    // Get all chefs
    @GetMapping
    public List<Chef> getAllChefs() {
        return chefService.getAllChefs();
    }

    // Get chef by ID
    @GetMapping("/{id}")
    public Chef getChefById(@PathVariable int id) {
        return chefService.getChefById(id);
    }

    // Delete chef
    @DeleteMapping("/{id}")
    public String deleteChef(@PathVariable int id) {
        chefService.deleteChef(id);
        return "Chef deleted successfully";
    }
}
