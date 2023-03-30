package com.example.drones.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Base64;

@Data
@Entity
@Table(name = "Medications")
public class medication {

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
