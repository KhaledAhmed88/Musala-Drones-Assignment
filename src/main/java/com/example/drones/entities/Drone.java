package com.example.drones.entities;

import com.example.drones.enums.DroneModel;
import com.example.drones.enums.DroneState;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    @Range(min = 1, max = 500)
    @Column(name = "weightLimit")
    private Double weightLimit;

    @Range(min = 0, max = 100)
    @Column(name = "batteryCapacity")
    private Integer batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DroneState state;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @OneToMany(mappedBy = "drone", targetEntity = Medication.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Medication> medications;
}
