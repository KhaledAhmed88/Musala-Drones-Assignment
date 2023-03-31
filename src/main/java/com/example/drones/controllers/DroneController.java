package com.example.drones.controllers;

import com.example.drones.dtos.DroneDTO;
import com.example.drones.dtos.MedicationDTO;
import com.example.drones.entities.Drone;
import com.example.drones.services.DroneService;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<String> register(@RequestBody DroneDTO droneDTO) {
        try {
            return new ResponseEntity<>(droneService.addDrone(droneDTO), HttpStatus.CREATED);
        } catch(Exception e) {
            if (e instanceof ConstraintViolationException) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public @ResponseBody ResponseEntity<String> addDroneMedication(@RequestBody MedicationDTO medicationDTO) {
        try {
            return new ResponseEntity<>(droneService.addDroneMedication(medicationDTO), HttpStatus.CREATED);
        } catch(Exception e) {
            if (e instanceof ConstraintViolationException) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
