package com.example.sportsbetting;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.sportsbetting.config.AppConfig;
import com.example.sportsbetting.config.JpaConfig;

public class AppSpring {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class)) {
            App app = appContext.getBean(App.class);
            //app.sportsBettingService.setRepositories(appContext);

            /*testJpa(appContext);
            testSpringData(appContext);

             */
            app.play();
            System.out.println("PROGRAM ENDS");
        }
    }

}
