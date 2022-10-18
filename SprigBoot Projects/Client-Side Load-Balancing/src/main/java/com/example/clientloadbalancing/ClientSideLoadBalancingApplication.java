package com.example.clientloadbalancing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@RestController
@SpringBootApplication
public class ClientSideLoadBalancingApplication {

    private static Logger log = LoggerFactory.getLogger(ClientSideLoadBalancingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientSideLoadBalancingApplication.class, args);
    }

    @GetMapping("/greeting")
    public String greet(){
            log.info("Access /greeting");

            List<String> greetings = Arrays.asList("Hi There", "Greetings", "Konnichiwa");
            Random rand = new Random();
            Integer randomNum = rand.nextInt(greetings.size());
            return greetings.get(randomNum);
    }

    @GetMapping("/")
    public String home() {
        log.info("Access /");
        return "Hi";
    }

}
