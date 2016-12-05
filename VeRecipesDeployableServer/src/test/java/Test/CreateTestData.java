/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import com.samoryka.verecipesdeployableserver.Service.AppUserRecipeService;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import com.samoryka.verecipesdeployableserver.Service.RecipeService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kasam
 */
public class CreateTestData {
    
    public static void main(String[] args) throws Throwable {
         RecipeService recipeServ = new RecipeService();
         AppUserService userServ = new AppUserService();
         AppUserRecipeService userRecipeServ = new AppUserRecipeService();
         
         Recipe recipe1 = new Recipe((long) 0, "Yasa Chicken 1","google.fr", "google.com", 90,new Date());
         recipeServ.createRecipe(recipe1);
         
         Recipe recipe2 = new Recipe((long) 0, "Yasa Chicken 2","google.fr", "google.com", 90,new Date());
         recipeServ.createRecipe(recipe2);
         
         Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.JUNE);
        cal.set(Calendar.DAY_OF_MONTH, 16);
        
         Recipe recipe3 = new Recipe((long) 0, "Yasa Chicken 3","google.fr", "google.com", 90,cal.getTime());
         recipeServ.createRecipe(recipe3);
         
         AppUser samory = new AppUser("samauriz", "password", "ka.samory@gmail.com");
         userServ.createAppUser(samory);
         
         userRecipeServ.createAppUserRecipe(samory, recipe1);
         userRecipeServ.createAppUserRecipe(samory, recipe3);
         
         // List all the recipes saved by Samory
        List<Recipe> savdRecipes = recipeServ.getRecipesSavedByUser(samory.getId());
        for(Recipe r : savdRecipes) {
            System.out.println(r);
        }
        System.out.println();
    }
    
}
