package com.recipe.sriharish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.sriharish.model.Chef;
import com.recipe.sriharish.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    // Find all recipes by a specific chef
    List<Recipe> findByChefId(int chefId);

    // Optional: find by name
    Recipe findByName(String name);
 List<Recipe> findByChef(Chef chef);

}
//==============WITHOUT SPRING==================//



// public List<Recipe> findByChefId(int chefId) {
//     List<Recipe> recipes = new ArrayList<>();
//     String sql = "SELECT * FROM RECIPE WHERE chef_id = ?";
    
//     try (Connection conn = DriverManager.getConnection(dbUrl, user, pass);
//          PreparedStatement ps = conn.prepareStatement(sql)) {
         
//         ps.setInt(1, chefId);
//         ResultSet rs = ps.executeQuery();
        
//         while (rs.next()) {
//             Recipe recipe = new Recipe();
//             recipe.setId(rs.getInt("id"));
//             recipe.setName(rs.getString("name"));
//             recipe.setInstructions(rs.getString("instructions"));
//             // ... map chef object if needed
//             recipes.add(recipe);
//         }
        
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//     return recipes;
// }
