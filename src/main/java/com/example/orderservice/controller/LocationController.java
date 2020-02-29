package com.example.orderservice.controller;


import com.example.orderservice.exception.LocationNotFoundException;
import com.example.orderservice.model.Location;
import com.example.orderservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @GetMapping("/{id}")
    public Optional<Location> findLocationById(@PathVariable Long id) {
        Optional<Location> location = locationRepository.findById(id);
        if (!location.isPresent()) {
            throw new LocationNotFoundException("id - " + id);
        }
        return locationRepository.findById(id);
    }
}
