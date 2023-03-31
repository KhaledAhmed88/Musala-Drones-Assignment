package com.example.drones.dtos;

import com.example.drones.enums.DroneModel;
import com.example.drones.enums.DroneState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneDTO {

    private String serialNumber;
    private DroneModel model;
    private Double weightLimit;
    private Integer batteryCapacity;
    private DroneState state;
}
