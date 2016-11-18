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
    private String ingredients;
    private String steps;
    private int cookingTime;
    private int preparationTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationTime;

    public Recipe(){};
    
    public Recipe(String name, String ingredients, String steps, int cookingTime, int preparationTime, Date publicationTime) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.publicationTime = publicationTime;
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

    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public Date getPublicationTime() {
        return publicationTime;
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

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }
}
