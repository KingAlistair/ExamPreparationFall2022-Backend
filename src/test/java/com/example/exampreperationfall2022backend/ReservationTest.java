package com.example.exampreperationfall2022backend;

import com.example.exampreperationfall2022backend.entity.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReservationTest {


    @Test
    void checkRentalDate() {
        //given
        LocalDate dateNow = LocalDate.now();
        //when
        Reservation reservation = new Reservation();
        //then
        assertThat(reservation.getRentalDate()).isEqualTo(dateNow);

    }
}
