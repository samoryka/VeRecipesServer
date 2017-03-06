package com.samoryka.verecipesdeployableserver.Security;

import com.samoryka.verecipesdeployableserver.Model.AppUser;
import com.samoryka.verecipesdeployableserver.Service.AppUserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Configuration of the authentication on VeRecipes' Server
 *
 * @author Samory Ka
 */
@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
    
    // Configuration of the user database used to authenticate
    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUserService userSrv = new AppUserService();
                AppUser appUser = new AppUser();
                try {
                     appUser = userSrv.getAppUserByUsername(username);
                } catch (Throwable ex) {
                    Logger.getLogger(AuthenticationConfiguration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (appUser.getId() > 0)
                {
                    if(appUser.getUsername().equals("samory"))
                        return new User(appUser.getUsername(), appUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                    else
                        return new User(appUser.getUsername(), appUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
                }
                    
                else
                    throw new UsernameNotFoundException("could not find the user '"+ username + "'");
            }
        };
                
    } 
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  // Configuration of the authorizations
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/swagger-ui.html").permitAll()    // any person can view the documentation
            .antMatchers(HttpMethod.PUT,"/user").permitAll()    // any person can sign up
            .antMatchers(HttpMethod.PUT,"/recipe").hasRole("ADMIN") // only an admin can add a recipe
            .anyRequest().fullyAuthenticated()
            .and().formLogin().loginPage("/").permitAll()
            .and().httpBasic()
            .and().csrf().disable();    
  }
  
}
