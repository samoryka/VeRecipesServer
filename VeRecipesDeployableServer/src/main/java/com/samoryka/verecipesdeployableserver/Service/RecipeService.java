package com.samoryka.verecipesdeployableserver.Service;

import com.samoryka.verecipesdeployableserver.Dao.JpaUtil;
import com.samoryka.verecipesdeployableserver.Dao.RecipeDao;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import com.samoryka.verecipesdeployableserver.Utility.RecipeUtilities;
import java.util.Date;
import java.util.List;

/**
 * Java Intelligence and dao calls for Recipes
 *
 * @author Samory Ka
 */
public class RecipeService {

    private RecipeDao dao;

    public RecipeService() {
        JpaUtil.init();
        dao = new RecipeDao();
    }

    public void createRecipe(Recipe recipe) throws Throwable {

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        RecipeUtilities.correctJSONTextFormatting(recipe);
        dao.create(recipe);

        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();

    }

    public List<Recipe> getAllRecipes() throws Throwable {
        JpaUtil.createEntityManager();

        List<Recipe> recipes = dao.findAll();
        
        JpaUtil.closeEntityManager();

        return recipes;
    }

    public List<Recipe> getRecipesByDate(Date date) throws Throwable {
        JpaUtil.createEntityManager();

        List<Recipe> recipes = dao.findByDate(date);

        JpaUtil.closeEntityManager();

        return recipes;
    }

    public List<Recipe> getRecipesSavedByUser(Long userId) throws Throwable {

        JpaUtil.createEntityManager();

        List<Recipe> recipes = dao.findByAppUser(userId);

        JpaUtil.closeEntityManager();

        return recipes;
    }
}
