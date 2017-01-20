package com.samoryka.verecipesdeployableserver.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Entity representing a link between a user and a recipe
 * (the user saved the recipe)
 * 
 * @author Samory Ka
 */
@Entity
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"appUserId", "recipeId"}))

public class AppUserRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long appUserId;
    private long recipeId;

    public AppUserRecipe() {
    }

    public AppUserRecipe(long appUserId, long recipeId) {
        this.appUserId = appUserId;
        this.recipeId = recipeId;
    }

    public AppUserRecipe(AppUser user, Recipe recipe) {
        this.appUserId = user.getId();
        this.recipeId = recipe.getId();
    }

    public long getId() {
        return id;
    }

    public long getAppUserId() {
        return appUserId;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAppUserId(long appUserId) {
        this.appUserId = appUserId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

}
