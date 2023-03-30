package com.example.drones.controllers;

import com.example.drones.entities.Drone;
import com.example.drones.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping("/register")
    public @ResponseBody String register(@RequestBody Drone drone) {
        droneService.addDrone(drone);
        return "Drone has been registered successfully";
    }

    @GetMapping
    public @ResponseBody List<Drone> getDrones() {
        return droneService.getDrones();
    }
}
