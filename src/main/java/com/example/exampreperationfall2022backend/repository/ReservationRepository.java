package com.example.exampreperationfall2022backend.repository;

import com.example.exampreperationfall2022backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
