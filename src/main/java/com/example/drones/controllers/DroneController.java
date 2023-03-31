package com.example.drones.controllers;

import com.example.drones.entities.Drone;
import com.example.drones.entities.Medication;
import com.example.drones.services.DroneService;
import com.example.drones.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    @PostMapping("/register")
    public @ResponseBody String register(@RequestBody Drone drone) {
        droneService.addDrone(drone);
        return "Drone has been registered successfully";
    }

    @GetMapping("/medications")
    public @ResponseBody Page<Drone> getDrones(@RequestParam(name="droneId", required = false) Integer droneId,
                                               @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) {
        return droneService.getDrones(droneId, page, size);
    }

    @GetMapping("/availability")
    public @ResponseBody Page<Drone> getAvailableDrones(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) {
        return droneService.getAvailableDrones(page, size);
    }

    @GetMapping("/battery/{id}")
    public @ResponseBody Map<String, Integer> getDroneBatteryLevel(@PathVariable(name="id") Integer droneId) {
        return droneService.getDroneBatteryLevel(droneId);
    }

    @PostMapping("/medication")
    public @ResponseBody String addDroneMedication(@RequestBody Medication medication) {
        medicationService.addDroneMedication(medication);
        return "Medication has been added successfully";
    }
}
