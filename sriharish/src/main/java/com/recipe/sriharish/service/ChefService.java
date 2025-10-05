package com.recipe.sriharish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.sriharish.dao.ChefRepository;
import com.recipe.sriharish.model.Chef;

@Service
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;

    // Register a new chef
    public Chef registerChef(Chef chef) {
        return chefRepository.save(chef);
    }

    // Authenticate login
    public boolean authenticateChef(String username, String password) {
        Chef chef = chefRepository.findByUsernameAndPassword(username, password);
        return chef != null;
    }

    // Get all chefs
    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    // Get chef by ID
    public Chef getChefById(int id) {
        return chefRepository.findById(id).orElse(null);
    }

    // Delete chef
    public void deleteChef(int id) {
        chefRepository.deleteById(id);
    }
}
