package com.example.exampreperationfall2022backend.controller;

import com.example.exampreperationfall2022backend.entity.Car;
import com.example.exampreperationfall2022backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCar() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createcAr(@RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
        return new ResponseEntity<>(carService.updateCar(id, car), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}