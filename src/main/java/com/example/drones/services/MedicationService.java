package com.example.drones.services;

import com.example.drones.entities.Medication;
import com.example.drones.repositories.MedicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    @Autowired
    MedicationRepo medicationRepo;

    public void addDroneMedication(Medication medication) {
        medicationRepo.save(medication);
    }
}
