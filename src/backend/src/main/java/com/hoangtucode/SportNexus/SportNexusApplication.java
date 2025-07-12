package com.hoangtucode.SportNexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.hoangtucode.SportNexus")
@EnableJpaAuditing
public class SportNexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportNexusApplication.class, args);
    }

}
