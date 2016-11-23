/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.AppUserRecipeDao;
import Dao.JpaUtil;
import Model.AppUser;
import Model.AppUserRecipe;
import Model.Recipe;
import java.util.List;

/**
 *
 * @author kasam
 */
public class AppUserRecipeService {

    private AppUserRecipeDao dao;

    public AppUserRecipeService() {
        JpaUtil.init();
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
