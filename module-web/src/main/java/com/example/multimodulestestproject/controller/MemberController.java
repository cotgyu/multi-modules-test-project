package com.example.multimodulestestproject.controller;

import com.example.multimodulestestproject.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/")
    public Member get() {
        return new Member("v123v123s", "v123v123s@gmail.com");
    }
}