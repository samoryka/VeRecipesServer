/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Recipe implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String imageURL;
    private String ingredients;
    private String steps;
    private int cookingTime;
    private int preparationTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationDate;

    // A Blank constructor is necessary for JPA
    public Recipe(){};
    
    public Recipe(String name, String imageURL, String ingredients, String steps, int cookingTime, int preparationTime, Date publicationTime) {
        this.name = name;
        this.imageURL = imageURL;
        this.ingredients = ingredients;
        this.steps = steps;
        this.cookingTime = cookingTime;
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

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
    

    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getPreparationDate() {
        return preparationTime;
    }

    public Date getPublicationTime() {
        return publicationDate;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
