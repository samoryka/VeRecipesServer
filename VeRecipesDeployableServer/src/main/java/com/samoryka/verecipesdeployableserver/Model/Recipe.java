package com.samoryka.verecipesdeployableserver.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Entity representing a recipe saved in VeRecipe's database
 * 
 * @author Samory Ka
 */
@Entity
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sourceId;  // The id that references the recipe in the source
    private String name;
    private String imageURL;
    private String recipeURL;
    private int preparationTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationDate;

    // A Blank constructor is necessary for JPA
    public Recipe() {
    }

    ;
    
    public Recipe(Long sourceId, String name, String imageURL, String recipeURL, int preparationTime, Date publicationTime) {
        this.sourceId = sourceId;
        this.name = name;
        this.imageURL = imageURL;
        this.recipeURL = recipeURL;
        this.preparationTime = preparationTime;
        this.publicationDate = publicationTime;
    }

    @Override
    public String toString() {
        return "Recipe " + id + ": " + name;
    }

    public Long getId() {
        return id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getRecipeURL() {
        return recipeURL;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setRecipeURL(String recipeURL) {
        this.recipeURL = recipeURL;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
