package com.samoryka.verecipesdeployableserver.Model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Entity representing a user of VeRecipes (we chose the "AppUser" name because
 * the "User" name is usuallt reserved in relational databases)
 * 
 * @author Samory Ka
 */
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String mail;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date signUpDate;

    public AppUser(String username, String password, String mail, Date signupDate) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.signUpDate = signupDate;
    }

    public AppUser(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.signUpDate = Calendar.getInstance().getTime();
    }

    // A Blank constructor is necessary for JPA
    public AppUser() {
    }

    ;
    
    @Override
    public String toString() {
        return "User: " + this.username + ", " + this.mail + ", join on " + this.signUpDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public long getId() {
        return id;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

}
