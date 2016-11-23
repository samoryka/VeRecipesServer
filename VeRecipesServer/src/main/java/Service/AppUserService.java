/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.JpaUtil;
import Dao.AppUserDao;
import Model.AppUser;
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
    
    public List<AppUser> getAllAppUsers() throws Throwable {
        JpaUtil.createEntityManager();
        
        List<AppUser> users =  dao.findAll();
        
        JpaUtil.closeEntityManager();
        
        return users;
    }
    
}
