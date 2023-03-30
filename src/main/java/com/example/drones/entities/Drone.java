package com.example.drones.entities;

import com.example.drones.enums.DroneModel;
import com.example.drones.enums.DroneState;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "Drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serialNumber", length = 100)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "model")
    private DroneModel model;

    @Column(name = "weightLimit")
    private String weightLimit;

    @Size(min = 0, max = 100)
    @Column(name = "batteryCapacity")
    private double batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DroneState state;

    @OneToMany
    @Column(nullable = true)
    private List<Medication> medications;
}
