/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Service;

import com.samoryka.verecipesdeployableserver.Dao.JpaUtil;
import com.samoryka.verecipesdeployableserver.Dao.RecipeDao;
import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kasam
 */
public class RecipeService {
    
    private RecipeDao dao;
    
    public RecipeService(){
        JpaUtil.init();
        dao = new RecipeDao();
    }
    
    public void createRecipe(Recipe recipe) throws Throwable{
        
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        dao.create(recipe);
        
        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();
        
    }
    
    public List<Recipe> getAllRecipes() throws Throwable {
        JpaUtil.createEntityManager();
        
        List<Recipe> recipes =  dao.findAll();
        
        JpaUtil.closeEntityManager();
        
        return recipes;
    }
    
    public List<Recipe> getRecipesByDate(Date date) throws Throwable {
        JpaUtil.createEntityManager();
        
        List<Recipe> recipes =  dao.findByDate(date);
        
        JpaUtil.closeEntityManager();
        
        return recipes;
    }
    
    public List<Recipe> getRecipesSavedByUser(Long userId) throws Throwable {
        
        JpaUtil.createEntityManager();
        
        List<Recipe> recipes =  dao.findByAppUser(userId);
        
        JpaUtil.closeEntityManager();
        
        return recipes;
    }
}
