package com.example.drones.repositories;

import com.example.drones.entities.Medication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicationRepo extends PagingAndSortingRepository<Medication, Long> {

}