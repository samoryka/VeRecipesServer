package com.samoryka.verecipesdeployableserver.Web;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maps HTTP Requests to the User Service
 *
 * @author Samory Ka
 */
@Api(tags = "Users")
@RestController
public class UserRestController {

    private AppUserService userSrv = new AppUserService();

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    boolean signUp(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "mail", required = true) String mail
    ) throws Throwable {

        //We create a user and try to save him in the database
        AppUser newUser = new AppUser(username, password, mail);
        userSrv.createAppUser(newUser);

        //We check that the user has been saved in the database and return the according boolean
        AppUser testUser = userSrv.getAppUserByUsername(username);
        return testUser.getUsername() == newUser.getUsername();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    AppUser login(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password
    ) throws Throwable {

        //We check that the user has been saved in the database and return the according boolean
        return userSrv.login(username, password);
    }

}
