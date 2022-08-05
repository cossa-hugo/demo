package com.example.sandbox.demo.service;

import com.example.sandbox.demo.dao.CityRepository;
import com.example.sandbox.demo.entity.City;
import com.example.sandbox.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = (List<City>) cityRepository.findAll();

        if (cities.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    public ResponseEntity<City> getCityById(int id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No city found with id = " + id));
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    public ResponseEntity<City> createCity(City city) {
        City _city = cityRepository.save(new City(city.getId(), city.getName(), city.getCountry(), city.getPopulationNumber()));
        return new ResponseEntity<>(_city, HttpStatus.CREATED);
    }

    public ResponseEntity<City> updateCity(int id, City city) {
        City _city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        _city.setName(_city.getName());
        _city.setCountry(_city.getCountry());
        _city.setPopulationNumber(_city.getPopulationNumber());

        return new ResponseEntity<>(cityRepository.save(_city), HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteCity(int id) {
        cityRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteAllCity() {
        cityRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
