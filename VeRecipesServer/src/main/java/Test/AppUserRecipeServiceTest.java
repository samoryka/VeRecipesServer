/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.AppUser;
import Model.Recipe;
import Service.AppUserRecipeService;
import Service.AppUserService;
import Service.RecipeService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kasam
 */
public class AppUserRecipeServiceTest {
     public static void main(String[] args) throws Throwable {
         RecipeService recipeServ = new RecipeService();
         AppUserService userServ = new AppUserService();
         AppUserRecipeService userRecipeServ = new AppUserRecipeService();
         
         Recipe recipe1 = new Recipe("Yasa Chicken 1","google.fr", "Chicken;;onions;;mustard", "Cook it;;Eat it", 60,90,new Date());
         recipeServ.createRecipe(recipe1);
         
         Recipe recipe2 = new Recipe("Yasa Chicken 2","google.fr", "Chicken;;onions;;mustard", "Cook it;;Eat it", 60,90,new Date());
         recipeServ.createRecipe(recipe2);
         
         Recipe recipe3 = new Recipe("Yasa Chicken 3","google.fr", "Chicken;;onions;;mustard", "Cook it;;Eat it", 60,90,new Date());
         recipeServ.createRecipe(recipe3);
         
         AppUser samory = new AppUser("samauriz", "password", "ka.samory@gmail.com");
         userServ.createAppUser(samory);
         
         userRecipeServ.createAppUserRecipe(samory, recipe1);
         userRecipeServ.createAppUserRecipe(samory, recipe3);
         
         // List all the recipes saved by Samory
        List<Recipe> savdRecipes = recipeServ.getRecipesSavedByUser(samory);
        for(Recipe r : savdRecipes) {
            System.out.println(r);
        }
        System.out.println();
         
         
         
     }
    
}
