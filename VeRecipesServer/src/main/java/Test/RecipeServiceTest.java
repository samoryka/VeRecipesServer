package Test;
import Model.Recipe;
import Service.RecipeService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kasam
 */
public class RecipeServiceTest {
    
    public static void main(String[] args) throws Throwable {
        Recipe recipe1 = new Recipe("Yasa Chicken","google.fr", "Chicken;;onions;;mustard", "Cook it;;Eat it", 60,90,new Date());
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.JUNE);
        cal.set(Calendar.DAY_OF_MONTH, 16);
        
        Recipe recipe2 = new Recipe("Yasa Chicken 2","google.com", "Chicken;;onions;;mustard", "Cook it;;Eat it", 60,90,cal.getTime());
        
        RecipeService serv = new RecipeService();
        
        serv.createRecipe(recipe1);
        serv.createRecipe(recipe2);
        
        
        // Test of the acquisition of all recipes
        System.out.println("ALL RECIPES :");
        List<Recipe> allRecipes = serv.getAllRecipes();
        for(Recipe r : allRecipes) {
            System.out.println(r);
        }
        System.out.println();
        
        // Test of the acquisition of all recipes at a certain date
        System.out.println("RECIPES AT A CERTAIN DATE :");
        List<Recipe> recipesByDate = serv.getRecipesByDate(recipe1.getPublicationTime());
        for(Recipe r : recipesByDate) {
            System.out.println(r);
        }
        System.out.println();
        
    }
}
