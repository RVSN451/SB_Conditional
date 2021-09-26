package com.example.demo.controller;

import com.example.demo.model.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    private final SystemProfile profile;

    public Controller(SystemProfile profile) {
        this.profile = profile;
    }

    @RequestMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}
