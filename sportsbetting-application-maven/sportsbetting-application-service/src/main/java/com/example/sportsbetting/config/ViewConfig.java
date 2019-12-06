package com.example.sportsbetting.config;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.example.sportsbetting.View;

@Configuration
@Import(MessageSourceConfig.class)
@PropertySource(value = { "classpath:config.properties" }, encoding = "UTF-8")
public class ViewConfig {
    @Value("${default.language}")
    private Locale locale;

    @Inject
    private MessageSource messageSource;

    @Bean
    public View view() {
        View view = new View();
        view.locale = locale;
        view.messageSource = messageSource;
        return view;
    }
}
