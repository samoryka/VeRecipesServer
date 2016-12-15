/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samoryka.verecipesdeployableserver.Dao;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
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
        } catch (Exception e) {
            throw e;
        }
    }

    public AppUser update(AppUser user) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            user = em.merge(user);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    public AppUser findById(Long id) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        AppUser client = null;
        try {
            client = em.find(AppUser.class, id);
        } catch (Exception e) {
            throw e;
        }
        return client;
    }

    public AppUser findByUsername(String username) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        AppUser user = null;
        try {

            String query = "SELECT au FROM AppUser au WHERE au.username = ?1";
            Query q = em.createQuery(query).setParameter(1, username);
            user = (AppUser) q.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
    public AppUser findByUsernameAndPassword(String username, String password) throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        AppUser user = null;
        try {

            String query = "SELECT au FROM AppUser au WHERE au.username = ?1 AND au.password = ?2";
            Query q = em.createQuery(query).setParameter(1, username);
            q.setParameter(2, password);
            user = (AppUser) q.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    public List<AppUser> findAll() throws Throwable {
        EntityManager em = JpaUtil.getEntityManager();
        List<AppUser> users = null;
        try {
            Query q = em.createQuery("SELECT u FROM AppUser u");
            users = (List<AppUser>) q.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return users;
    }

}
