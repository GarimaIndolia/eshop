package com.shopping.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
@PropertySource("classpath:config.properties")
//@EnableJpaRepositories("com.dao")
@EntityScan("com.shopping.cart.bean")
@ComponentScan("module-service")
public class ShoppingCartAPIMain extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartAPIMain.class, args);
	}
	  @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(ShoppingCartAPIMain.class);
	    }
	  
	  @RequestMapping("/")
	  public String home() {
	    return "Hello World";
	  }
}
