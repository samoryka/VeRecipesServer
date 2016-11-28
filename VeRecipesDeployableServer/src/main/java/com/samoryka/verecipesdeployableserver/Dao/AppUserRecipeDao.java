/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Dao;

import com.samoryka.verecipesdeployableserver.Model.AppUserRecipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author kasam
 */
public class AppUserRecipeDao {
    
    public void create(AppUserRecipe userRecipe) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.persist(userRecipe);
        }
        catch(Exception e) {
            throw e;
        }
    }
    
    public void delete(AppUserRecipe userRecipe) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
        em.remove(userRecipe);
        }
        catch(Exception e) {
            throw e;
        }
    }
    
    public List<AppUserRecipe> findByUserId(long userId) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<AppUserRecipe> appUserRecipes = null;
        try {
            String query = "SELECT a FROM AppUserRecipe a WHERE a.appUserId = ?1";
            Query q = em.createQuery(query).setParameter(1, userId);
            appUserRecipes = (List<AppUserRecipe>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }     
        return appUserRecipes;
    }
    
    public List<AppUserRecipe> findByRecipeId(long recipeId) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<AppUserRecipe> appUserRecipes = null;
        try {
            String query = "SELECT a FROM AppUserRecipe a WHERE a.recipeId = ?1";
            Query q = em.createQuery(query).setParameter(1, recipeId);
            appUserRecipes = (List<AppUserRecipe>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }     
        return appUserRecipes;
    }
    
}
