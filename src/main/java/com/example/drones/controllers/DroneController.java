package com.example.drones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/test")
public class DroneController {

    @GetMapping
    public @ResponseBody String test() {
        return "Ok!";
    }
}
