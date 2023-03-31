package com.example.drones.repositories;

import com.example.drones.entities.Medication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends PagingAndSortingRepository<Medication, Long> {

    @Query("select sum(m.weight) from Drone d inner join Medication m on d.id = m.drone.id where d.id >= ?1")
    Double weightSum(Integer droneId);
}