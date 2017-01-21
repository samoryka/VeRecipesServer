package com.samoryka.verecipesdeployableserver.Utility;

import com.samoryka.verecipesdeployableserver.Model.Recipe;

/**
 * This class contains recurrent tasks that wa can do on recipes
 * @author kasam
 */
public class RecipeUtilities {
    
    /**
     * Corrects the "@@" characters that we add in recipes when adding them thgough a request
     * @param recipe 
     */
    public static void correctJSONTextFormatting(Recipe recipe) {

        recipe.setName( recipe.getName().replaceAll("@@and","&"));
        recipe.setName( recipe.getName().replaceAll("@@hashtag","#"));
        recipe.setName( recipe.getName().replaceAll("@@openingCurvedBracket","{"));
        recipe.setName( recipe.getName().replaceAll("@@closingCurvedBracket","}"));
        recipe.setName( recipe.getName().replaceAll("@@openingSquareBracket","["));
        recipe.setName( recipe.getName().replaceAll("@@closingSquareBracket","]"));

        recipe.setImageURL( recipe.getImageURL().replaceAll("@@and","&"));
        recipe.setImageURL( recipe.getImageURL().replaceAll("@@hashtag","#"));
        recipe.setImageURL( recipe.getImageURL().replaceAll("@@openingCurvedBracket","{"));
        recipe.setImageURL( recipe.getImageURL().replaceAll("@@closingCurvedBracket","}"));
        recipe.setImageURL( recipe.getImageURL().replaceAll("@@openingSquareBracket","["));
        recipe.setImageURL( recipe.getImageURL().replaceAll("@@closingSquareBracket","]"));

        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@and","&"));
        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@hashtag","#"));
        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@openingCurvedBracket","{"));
        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@closingCurvedBracket","}"));
        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@openingSquareBracket","["));
        recipe.setRecipeURL( recipe.getRecipeURL().replaceAll("@@closingSquareBracket","]"));
    }
}
