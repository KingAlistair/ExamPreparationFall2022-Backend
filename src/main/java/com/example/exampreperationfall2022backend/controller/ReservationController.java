package com.example.exampreperationfall2022backend.controller;

import com.example.exampreperationfall2022backend.entity.Reservation;
import com.example.exampreperationfall2022backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/carReservations/{id}/{date}")
    public boolean getCarReservation(@PathVariable("id") Long id,@PathVariable String date) throws ParseException {
        List<Reservation> reservations = reservationService.getAllReservations();
        List<Reservation> carReservations = new ArrayList<>();

       reservations = reservations.stream().filter(item -> item.getCar().getId() == id).collect(Collectors.toList());




        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        LocalDate localdate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();



        for (Reservation reservation : reservations
        ) {
            System.out.println(reservation.getReservationDate());
            if (reservation.getReservationDate().equals(localdate)) {
                return false;
            }
        }
        return true;
    }
}