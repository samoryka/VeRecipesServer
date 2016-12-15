/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Service;

import com.samoryka.verecipesdeployableserver.Dao.JpaUtil;
import com.samoryka.verecipesdeployableserver.Dao.AppUserDao;
import com.samoryka.verecipesdeployableserver.Model.AppUser;
import java.util.List;

/**
 *
 * @author kasam
 */
public class AppUserService {
    
    private AppUserDao dao;
    
    public AppUserService(){
        JpaUtil.init();
        dao = new AppUserDao();
    }
    
    public void createAppUser(AppUser user) throws Throwable{
        
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        dao.create(user);
        
        JpaUtil.commitTransaction();
        JpaUtil.closeEntityManager();
        
    }
    
    public AppUser getAppUserById(long id) throws Throwable {
        JpaUtil.createEntityManager();
        
        AppUser user = dao.findById(id);
        
        JpaUtil.closeEntityManager();
        
        return user;
                
    }
    
    public AppUser getAppUserByUsername(String username) throws Throwable {
        JpaUtil.createEntityManager();
        
        AppUser user = dao.findByUsername(username);
        
        JpaUtil.closeEntityManager();
        
        return user;
                
    }
    
    public List<AppUser> getAllAppUsers() throws Throwable {
        JpaUtil.createEntityManager();
        
        List<AppUser> users =  dao.findAll();
        
        JpaUtil.closeEntityManager();
        
        return users;
    }
    
    public AppUser login(String username, String password) throws Throwable {
        JpaUtil.createEntityManager();
        
        AppUser user =  dao.findByUsernameAndPassword(username, password);
        
        JpaUtil.closeEntityManager();
        
        return user;
    }
    
}
