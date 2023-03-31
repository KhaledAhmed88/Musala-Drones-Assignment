package com.example.drones.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "Medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "^[A-Za-z0-9-_]+$")
    private String name;

    @Column(name = "weight")
    private String weight;

    @Column(name = "code")
    @Pattern(regexp = "^[A-Z-0-9_]+$")
    private String code;

    // base64
    @Column(name = "image", columnDefinition = "blob")
    private String image;

    @ManyToOne
    private Drone drone;
}
