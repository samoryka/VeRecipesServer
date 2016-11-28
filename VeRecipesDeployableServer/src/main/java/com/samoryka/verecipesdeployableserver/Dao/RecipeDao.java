/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Dao;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author kasam
 */
public class RecipeDao {
    
    public void create(Recipe recipe) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.persist(recipe);
        }
        catch(Exception e) {
            throw e;
        }
    }
    
    public Recipe update(Recipe recipe) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            recipe = em.merge(recipe);
        }
        catch(Exception e){
            throw e;
        }
        return recipe;
    }
    
    
    public Recipe findById(Long id) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        Recipe client = null;
        try {
            client = em.find(Recipe.class, id);
        }
        catch(Exception e) {
            throw e;
        }
        return client;
    }
    
    public List<Recipe> findAll() throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<Recipe> recipes = null;
        try {
            Query q = em.createQuery("SELECT r FROM Recipe r ORDER BY r.publicationDate");
            recipes = (List<Recipe>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }     
        return recipes;
    }
    
    public List<Recipe> findByDate(Date date) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<Recipe> recipes = null;
        try {
            String query = "SELECT r FROM Recipe r WHERE r.publicationDate = ?1";
            Query q = em.createQuery(query).setParameter(1, date, TemporalType.TIMESTAMP);
            recipes = (List<Recipe>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }     
        return recipes;
    }
    
    
    public List<Recipe> findByAppUser(Long userId) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<Recipe> recipes = null;
        try {
            String query = "SELECT r FROM Recipe r, AppUserRecipe aur WHERE r.id = aur.recipeId AND aur.appUserId = ?1";
            Query q = em.createQuery(query).setParameter(1, userId);
            recipes = (List<Recipe>) q.getResultList();
            }
        catch(Exception e) {
            throw e;
        }     
        return recipes;
    }
}
