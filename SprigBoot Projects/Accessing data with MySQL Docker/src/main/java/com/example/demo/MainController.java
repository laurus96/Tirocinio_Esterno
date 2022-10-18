package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String newUser(@RequestParam String name, @RequestParam String email){

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/id")
    public @ResponseBody Optional<User> existAndRetrive(@RequestParam Integer id){
        if(!userRepository.existsById(id))
            return null;

        return userRepository.findById(id);
    }

    @PostMapping(path = "/name")
    public @ResponseBody List<User> findByName(@RequestParam String name){
        return userRepository.findByName(name);
    }
}
