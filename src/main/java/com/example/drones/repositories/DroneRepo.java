package com.example.drones.repositories;

import com.example.drones.entities.Drone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends PagingAndSortingRepository<Drone, Long> {

    Page<Drone> findAll(Pageable pageable);

    Page<Drone> findAllById(Integer droneId, Pageable pageable);

    @Query("select d from Drone d where d.batteryCapacity >= ?1")
    Page<Drone> findAllAvailableDrones(Integer batteryCapacityMinThreshold, Pageable pageable);

    Drone findAllById(Integer droneId);
}