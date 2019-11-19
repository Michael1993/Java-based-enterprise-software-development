package com.example.sportsbetting;

import com.example.sportsbetting.config.AppConfig;

public class AppSpring {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);
            app.play();
        }
    }
}

