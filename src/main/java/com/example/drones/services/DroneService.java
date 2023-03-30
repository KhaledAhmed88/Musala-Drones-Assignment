package com.example.drones.services;

import com.example.drones.entities.Drone;
import com.example.drones.repositories.DroneRepo;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    @Autowired
    Environment environment;

    @Autowired
    DroneRepo droneRepo;

    public void addDrone(Drone drone) {
        droneRepo.save(drone);
    }

    public Page<Drone> getDrones(Integer droneId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (droneId == null) {
            return droneRepo.findAll(pageable);
        }

        return droneRepo.findAllById(droneId, pageable);
    }

    public Page<Drone> getAvailableDrones(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return droneRepo.findAllAvailableDrones(Integer.valueOf(environment.getProperty("drone.battery.min.threshold")),
                pageable);
    }

    public Drone getDroneBatteryLevel(Integer droneId) {
        return droneRepo.findAllById(droneId);
    }
}
