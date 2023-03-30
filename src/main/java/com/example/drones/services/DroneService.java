package com.example.drones.services;

import com.example.drones.entities.Drone;
import com.example.drones.repositories.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    DroneRepo droneRepo;

    public void addDrone(Drone drone) {
        droneRepo.save(drone);
    }

    public List<Drone> getDrones() {
        return droneRepo.findAll();
    }
}
