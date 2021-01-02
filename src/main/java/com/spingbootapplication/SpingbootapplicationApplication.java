package com.spingbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.repository")
@EntityScan("com.entity")
@EnableJpaAuditing
@ComponentScan(basePackages = {"com"})
public class SpingbootapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootapplicationApplication.class, args);
    }

}
