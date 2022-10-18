package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> getUsers() {
        return (List<Member>) memberRepository.findAll();
    }

    @GetMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        memberRepository.save(new Member(name, email));
        return "Saved";
    }
}
