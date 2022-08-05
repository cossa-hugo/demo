package com.example.sandbox.demo.controller;

import com.example.sandbox.demo.entity.City;
import com.example.sandbox.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api")
public class CityController {
    @Autowired
    private final CityService cityService;

    protected CityController(CityService citiesService) {
        this.cityService = citiesService;
    }

    // Endpoint to get info related to the health and the state of our service
    @GetMapping("/get-info")
    private String getStringMessage() {
        return "Try to monitor the health of your application!";
    }

    @GetMapping("/cities")
    private ResponseEntity<List<City>> getAllCities(@RequestParam(required = false) String country) {
        return cityService.getAllCities();
    }

    @GetMapping("/cities/{id}")
    private ResponseEntity<City> getCityById(@PathVariable("id") int id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/cities")
    private ResponseEntity<City> createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/cities/{id}")
    private ResponseEntity<City> updateCity(@PathVariable("id") int id, City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/cities/{id}")
    private ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") int id) {
        return cityService.deleteCity(id);
    }

    @DeleteMapping("/cities")
    private ResponseEntity<HttpStatus> deleteAllCity() {
        return cityService.deleteAllCity();
    }

}
