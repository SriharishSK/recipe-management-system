package com.recipe.sriharish.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.sriharish.model.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {
    // Custom method for login
    Chef findByUsernameAndPassword(String username, String password);
    Optional<Chef> findByUsername(String username);
    Optional<Chef> findByEmail(String email);

}


// 🔍 What’s happening here:

// 1️⃣ @Repository marks this interface as a DAO bean, so Spring can auto-detect and inject it.
// 2️⃣ extends JpaRepository<Chef, Integer>

// The first parameter <Chef> → the entity type.

// The second parameter <Integer> → the type of the entity’s primary key (id in Chef model).

// So this means:

// “Hey Spring, make me a repository for the Chef entity where the primary key is an Integer.”

// Now Spring automatically gives you these methods (no need to code them):

// findAll() → list all chefs

// findById(int id) → find a chef by ID

// save(Chef chef) → insert or update

// deleteById(int id) → delete

// count() → count rows
// and many more.

// All ready-to-use, no SQL needed 🤯