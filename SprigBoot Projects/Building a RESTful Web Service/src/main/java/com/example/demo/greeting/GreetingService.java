package com.example.demo.greeting;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    public Greeting greeting(String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
