package com.samoryka.verecipesdeployableserver.Web;

import com.samoryka.verecipesdeployableserver.Model.Recipe;
import com.samoryka.verecipesdeployableserver.Service.RecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maps HTTP Requests to the Recipe Service
 *
 * @author Samory Ka
 */
@Api(tags = "Recipes")
@RestController
public class RecipeRestController {

    private RecipeService recipeSrv = new RecipeService();

    @ApiOperation(value = "Returns the recipes saved by a user")
    @RequestMapping(value = "/recipes/user", method = RequestMethod.GET)
    List<Recipe> getRecipesSavedByUser(@RequestParam(value = "userId", required = true, defaultValue = "0") Long userId) throws Throwable {
        return recipeSrv.getRecipesSavedByUser(userId);
    }

    @ApiOperation(value = "Returns the recipes saved at a certain date")
    @RequestMapping(value = "/recipes/date", method = RequestMethod.GET)
    List<Recipe> getRecipesSavedAtDate(@RequestParam(value = "date", required = false) String dateString) throws Throwable {
        if (dateString != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateString);
            return recipeSrv.getRecipesByDate(date);
        } else {    // by default, we return today's recipes
            return recipeSrv.getRecipesByDate(Calendar.getInstance().getTime());
        }
    }

    // ----- ADMINISTRATION REQUESTS -----
    @RequestMapping(value = "/recipe", method = RequestMethod.PUT)
    void addRecipe(@RequestParam(value = "sourceId", required = true) long sourceId,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "imageURL", required = true) String imageURL,
            @RequestParam(value = "recipeURL", required = true) String recipeURL,
            @RequestParam(value = "preparationTime", required = true) int preparationTime,
            @RequestParam(value = "publicationDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date publicationDate)
            throws Throwable {

        Recipe newRecipe = new Recipe(sourceId, name, imageURL, recipeURL, preparationTime, publicationDate);
        recipeSrv.createRecipe(newRecipe);
    }
}
