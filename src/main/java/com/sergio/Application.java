package com.sergio;


import com.sergio.config.GraphqlConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GraphqlConfiguration.class)
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "demo");
        SpringApplication.run(Application.class, args);
    }
}
