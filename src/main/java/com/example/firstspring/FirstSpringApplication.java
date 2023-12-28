package com.example.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FirstSpringApplication{
    @GetMapping(path = "/hello")
    public String hello (){
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SpringAppContext SpringApplicationContext(){
        return new SpringAppContext();
    }
}
