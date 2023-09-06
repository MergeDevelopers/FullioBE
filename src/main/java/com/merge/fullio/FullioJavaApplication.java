package com.merge.fullio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FullioJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullioJavaApplication.class, args);
    }

}
