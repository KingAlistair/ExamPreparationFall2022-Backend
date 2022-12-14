package com.example.exampreperationfall2022backend.repository;

import com.example.exampreperationfall2022backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
