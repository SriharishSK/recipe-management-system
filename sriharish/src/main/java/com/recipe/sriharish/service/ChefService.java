package com.recipe.sriharish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.sriharish.dao.ChefRepository;
import com.recipe.sriharish.model.Chef;

import jakarta.servlet.http.HttpSession;

@Service
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private HttpSession session;

    // Register a new chef
    public Chef registerChef(Chef chef) {
        return chefRepository.save(chef);
    }

    public Chef findByUsername(String username) {
        return chefRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Chef not found: " + username));
    }
    
    public boolean existsByEmail(String email) {
        return chefRepository.findAll().stream()
                .anyMatch(chef -> chef.getEmail().equalsIgnoreCase(email));
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

     public Chef getLoggedInChef() {
         String username = (String) session.getAttribute("loggedInUsername");
    if (username != null) {
        return chefRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Chef not found: " + username));
    }
    throw new RuntimeException("No chef logged in");
    }

}
