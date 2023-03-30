package com.example.drones.controllers;

import com.example.drones.entities.Medication;
import com.example.drones.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService;

    @PostMapping
    public @ResponseBody String addDroneMedication(@RequestBody Medication medication) {
        medicationService.addDroneMedication(medication);
        return "Medication has been added successfully";
    }
}
