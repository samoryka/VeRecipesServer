package com.samoryka.verecipesdeployableserver.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main application of VeRecipes' server. It starts the server and links
 * the differents components automatically
 *
 * @author Samory Ka
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = VeRecipesServerApplication.class)
public class VeRecipesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeRecipesServerApplication.class, args);
    }
}
