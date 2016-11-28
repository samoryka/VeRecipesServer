/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Web;

import com.samoryka.verecipesdeployableserver.Model.Recipe;
import com.samoryka.verecipesdeployableserver.Service.AppUserRecipeService;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import com.samoryka.verecipesdeployableserver.Service.RecipeService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the main application of VeRecipes' Server.
 * It maps the HTTP REST requests with the corresponding Service calls.
 */

@RestController
@EnableAutoConfiguration
public class VeRecipesServerApplication {
    
    private RecipeService recipeSrv = new RecipeService();
    private AppUserService userSrv = new AppUserService();
    private AppUserRecipeService userRecipeSrv = new AppUserRecipeService();
    
    @RequestMapping("/hello")
    String hello(@RequestParam(value = "user", required = true, defaultValue = "anonymous") String user) {
        return "Hello " + user;
    }
    
    @RequestMapping("/recipes")
    List<Recipe> getAllRecipes() throws Throwable {
        return recipeSrv.getAllRecipes();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(VeRecipesServerApplication.class, args);
    }
}
