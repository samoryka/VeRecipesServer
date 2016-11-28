/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Web;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import com.samoryka.verecipesdeployableserver.Service.AppUserRecipeService;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import com.samoryka.verecipesdeployableserver.Service.RecipeService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the main application of VeRecipes' Server. It maps the HTTP REST
 * requests with the corresponding Service calls.
 */
@RestController
@EnableAutoConfiguration
public class VeRecipesServerApplication {

    private RecipeService recipeSrv = new RecipeService();
    private AppUserService userSrv = new AppUserService();
    private AppUserRecipeService userRecipeSrv = new AppUserRecipeService();

    // ----- RECIPE REQUESTS -----
    @RequestMapping(value = "/recipes/user", method = RequestMethod.GET)
    List<Recipe> getRecipesSavedByUser(@RequestParam(value = "userId", required = true, defaultValue = "0") Long userId) throws Throwable {
        return recipeSrv.getRecipesSavedByUser(userId);
    }

    @RequestMapping(value = "/recipes/date", method = RequestMethod.GET)
    List<Recipe> getRecipesSavedAtDate(@RequestParam(value = "date", required = false) String dateString) throws Throwable {
        if (dateString != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateString);
            return recipeSrv.getRecipesByDate(date);
        } else {    // by default, we return today's recipes
            return recipeSrv.getRecipesByDate(Calendar.getInstance().getTime());
        }
    }

    // ----- USER REQUESTS -----
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    boolean signUp(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "mail", required = true) String mail
    ) throws Throwable {

        //We create a user and try to save him in the database
        AppUser newUser = new AppUser(username, password, mail);
        userSrv.createAppUser(newUser);

        //We check that the user has been saved in the database and return the according boolean
        AppUser testUser = userSrv.getAppUserByUsername(username);
        return testUser.getUsername() == newUser.getUsername();

    }
    
    
    // ----- ADMINISTRATION REQUESTS (data management) -----
    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    void addRecipe(@RequestParam(value = "name", required = true) String name,
                      @RequestParam(value = "imageURL", required = true) String imageURL,
                      @RequestParam(value = "ingredients", required = true) String ingredients,
                      @RequestParam(value = "steps", required = true) String steps,
                      @RequestParam(value = "cookingTime", required = true) int cookingTime,
                      @RequestParam(value = "preparationTime", required = true) int preparationTime,
                      @RequestParam(value = "publicationDare", required = true) Date publicationDate)
            throws Throwable{
        
        Recipe newRecipe = new Recipe(name, imageURL, ingredients, steps, cookingTime, preparationTime, publicationDate);
        recipeSrv.createRecipe(newRecipe);
    }

    public static void main(String[] args) {
        SpringApplication.run(VeRecipesServerApplication.class, args);
    }
}
