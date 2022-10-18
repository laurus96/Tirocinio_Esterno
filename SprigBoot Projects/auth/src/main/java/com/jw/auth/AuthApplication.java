package com.jw.auth;

import com.jw.auth.entity.Role;
import com.jw.auth.entity.User;
import com.jw.auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPERADMIN"));

            userService.saveUser(new User(null, "John Travolta", "John", "1234567", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "Will", "1234567", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "Jim", "1234567", new ArrayList<>()));

            userService.addRoleToUser("John", "ROLE_USER");
            userService.addRoleToUser("John", "ROLE_ADMIN");
            userService.addRoleToUser("Will", "ROLE_SUPERADMIN");
            userService.addRoleToUser("Jim", "ROLE_ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
