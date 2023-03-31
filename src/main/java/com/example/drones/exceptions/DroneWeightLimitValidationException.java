package com.example.drones.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DroneWeightLimitValidationException extends ResponseStatusException {

    public DroneWeightLimitValidationException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
