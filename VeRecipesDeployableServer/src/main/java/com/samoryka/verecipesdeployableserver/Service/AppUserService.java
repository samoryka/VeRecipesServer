package com.samoryka.verecipesdeployableserver.Service;

import com.samoryka.verecipesdeployableserver.Dao.AppUserDao;
import com.samoryka.verecipesdeployableserver.Dao.JpaUtil;
import com.samoryka.verecipesdeployableserver.Model.AppUser;
import java.util.List;

/**
 * Java Intelligence and dao calls for AppUsers
 *
 * @author Samory Ka
 */
public class AppUserService {

    private AppUserDao dao;

    public AppUserService() {
        dao = new AppUserDao();
    }

    public void createAppUser(AppUser user) throws Throwable {

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        // TODO : full server-side verification of the user's credentials
        if (user.getPassword().length() >= 8) {
            dao.create(user);
        }

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

        List<AppUser> users = dao.findAll();

        JpaUtil.closeEntityManager();

        return users;
    }

    public AppUser login(String username, String password) throws Throwable {
        JpaUtil.createEntityManager();

        AppUser user = dao.findByUsernameAndPassword(username, password);

        JpaUtil.closeEntityManager();

        return user;
    }

}
