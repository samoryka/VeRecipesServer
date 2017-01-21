package com.samoryka.verecipesdeployableserver.Service;

import com.samoryka.verecipesdeployableserver.Dao.AppUserRecipeDao;
import com.samoryka.verecipesdeployableserver.Dao.JpaUtil;
import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Model.AppUserRecipe;
import com.samoryka.verecipesdeployableserver.Model.Recipe;
import java.util.List;

/**
 * Java Intelligence and dao calls for AppUserRecipes
 *
 * @author Samory Ka
 */
public class AppUserRecipeService {

    private AppUserRecipeDao dao;

    public AppUserRecipeService() {
        dao = new AppUserRecipeDao();
    }

    public void createAppUserRecipe(AppUserRecipe userRecipe) throws Throwable {

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        dao.create(userRecipe);

        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();

    }

    public void createAppUserRecipe(AppUser user, Recipe recipe) throws Throwable {

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        dao.create(new AppUserRecipe(user, recipe));

        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();

    }

    public void deleteAppUserRecipeByUserIdAndRecipeId(long userId, long recipeId) throws Throwable {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        AppUserRecipe userRecipe = dao.findByUserIdAndRecipeId(userId, recipeId);
        dao.delete(userRecipe);

        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();
    }

    public void deleteAppUserRecipe(AppUserRecipe userRecipe) throws Throwable {

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        dao.delete(userRecipe);

        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();

    }

    public List<AppUserRecipe> getAllByUserId(long userId) throws Throwable {
        JpaUtil.createEntityManager();

        List<AppUserRecipe> userRecipes = dao.findByUserId(userId);

        JpaUtil.closeEntityManager();

        return userRecipes;
    }

    public List<AppUserRecipe> getAllByRecipeId(long recipeId) throws Throwable {
        JpaUtil.createEntityManager();

        List<AppUserRecipe> userRecipes = dao.findByRecipeId(recipeId);

        JpaUtil.closeEntityManager();

        return userRecipes;
    }

}
