package com.example.sandbox.demo.dao;

import com.example.sandbox.demo.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

}
