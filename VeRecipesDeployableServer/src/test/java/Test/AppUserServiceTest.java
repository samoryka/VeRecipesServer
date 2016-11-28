/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author kasam
 */
public class AppUserServiceTest {
    
     public static void main(String[] args) throws Throwable {
         
         AppUserService serv = new AppUserService();
         
         AppUser samory = new AppUser("samauriz", "password", "ka.samory@gmail.com");
         serv.createAppUser(samory);
         
         Calendar cal = Calendar.getInstance();
         cal.set(Calendar.YEAR, 1995);
         
         AppUser samory2 = new AppUser("samaurizToo", "password", "samory.ka@mailbox.tu-dresden.de", cal.getTime());
         serv.createAppUser(samory2);
         
         
         // Test of the acquisition of all recipes
        System.out.println("ALL USERS :");
        List<AppUser> users = serv.getAllAppUsers();
        for(AppUser r : users) {
            System.out.println(r);
        }
     }
    
}
