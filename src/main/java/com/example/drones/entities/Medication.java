package com.example.drones.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
@Table(name = "Medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private String weight;

    @Column(name = "code")
    private String model;

    @Column(name = "image")
    private Blob image;
}
