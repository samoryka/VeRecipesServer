/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.JpaUtil;
import Dao.RecipeDao;
import Model.Recipe;

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
        try {
            dao.create(recipe);
        }catch(Exception e)
        {
            throw new Exception(e.getCause() +": Couldn't contact the database, please try again later");
        }
        
        
        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();
        
        
    }
}
