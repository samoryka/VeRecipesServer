/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.AppUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author kasam
 */
public class AppUserDao {
    
    public void create(AppUser user) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.persist(user);
        }
        catch(Exception e) {
            throw e;
        }
    }
    
    public AppUser update(AppUser user) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            user = em.merge(user);
        }
        catch(Exception e){
            throw e;
        }
        return user;
    }
    
    public AppUser findById(Long id) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        AppUser client = null;
        try {
            client = em.find(AppUser.class, id);
        }
        catch(Exception e) {
            throw e;
        }
        return client;
    }
    
    public List<AppUser> findAll() throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<AppUser> users = null;
        try {
            Query q = em.createQuery("SELECT u FROM AppUser u");
            users = (List<AppUser>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }     
        return users;
    }
    
}
