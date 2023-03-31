package com.example.drones.dtos;

import com.example.drones.entities.Drone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationDTO {
    private String name;
    private Double weight;
    private String code;
    private String image;
    private Drone drone;
}
