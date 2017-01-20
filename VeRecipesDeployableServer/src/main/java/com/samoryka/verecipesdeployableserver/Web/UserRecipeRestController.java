package com.samoryka.verecipesdeployableserver.Web;

import com.samoryka.verecipesdeployableserver.Model.AppUserRecipe;
import com.samoryka.verecipesdeployableserver.Service.AppUserRecipeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maps HTTP Requests to the UserRecipe Service
 *
 * @author Samory Ka
 */
@Api(tags = "Users-Recipes links")
@RestController
public class UserRecipeRestController {

    private AppUserRecipeService userRecipeSrv = new AppUserRecipeService();

    @RequestMapping(value = "/userRecipe", method = RequestMethod.PUT)
    void saveRecipe(@RequestParam(value = "userId", required = true) long userId,
            @RequestParam(value = "recipeId", required = true) long recipeId
    ) throws Throwable {
        AppUserRecipe save = new AppUserRecipe(userId, recipeId);
        userRecipeSrv.createAppUserRecipe(save);
    }

    @RequestMapping(value = "/userRecipe", method = RequestMethod.DELETE)
    void unsaveRecipe(@RequestParam(value = "userId", required = true) long userId,
            @RequestParam(value = "recipeId", required = true) long recipeId) throws Throwable {
        userRecipeSrv.deleteAppUserRecipeByUserIdAndRecipeId(userId, recipeId);
    }

}
