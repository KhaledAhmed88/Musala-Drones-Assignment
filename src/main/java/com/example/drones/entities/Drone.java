package com.example.drones.entities;

import com.example.drones.enums.DroneModel;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "serialNumber")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "model")
    private DroneModel model;

    @Column(name = "weightLimit")
    private String weightLimit;

    @Column(name = "batteryCapacity")
    private String batteryCapacity;

    @Column(name = "state")
    private String state;

}
