package com.example.drones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
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
    private Double weight;

    @Column(name = "code")
    @Pattern(regexp = "^[A-Z-0-9_]+$")
    private String code;

    // base64
    @Column(name = "image", columnDefinition = "blob")
    private String image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;
}
