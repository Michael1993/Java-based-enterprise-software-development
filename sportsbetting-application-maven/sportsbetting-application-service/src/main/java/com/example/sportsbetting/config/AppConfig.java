package com.example.sportsbetting.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.sportsbetting.App;
import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.View;

@Configuration
@Import({ SportsBettingService.class, ViewConfig.class, JpaConfig.class })
public class AppConfig {

    @Inject JpaConfig jpaconfig;

    @Inject
    private SportsBettingService sportsBettingService;

    @Inject
    private View view;

    public AppConfig() {
    }

    @Bean
    public App app() {
        return new App(sportsBettingService, view);
    }
}
