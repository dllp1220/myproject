package test5;

import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
 private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
 public void addViewControllers(ViewControllerRegistry registry) {
     registry.addViewController("/home").setViewName("home");
     registry.addViewController("/").setViewName("home");
     registry.addViewController("/login").setViewName("login");
 }
}