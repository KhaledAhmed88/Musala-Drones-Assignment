package com.example.drones.repositories;

import com.example.drones.entities.Drone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends PagingAndSortingRepository<Drone, Long> {

}