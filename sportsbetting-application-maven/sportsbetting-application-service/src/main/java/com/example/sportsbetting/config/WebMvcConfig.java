package com.example.sportsbetting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example.sportsbetting"})
public class WebMvcConfig implements WebMvcConfigurer {
 
   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   public void addResourceHandlers(final ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }
   
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/home").setViewName("home");
       registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
   }
}