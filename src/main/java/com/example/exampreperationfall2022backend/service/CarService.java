package com.example.exampreperationfall2022backend.service;

import com.example.exampreperationfall2022backend.entity.Car;
import com.example.exampreperationfall2022backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car) {
        if (carRepository.findById(id).isEmpty()) {
            return null;
        }
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}