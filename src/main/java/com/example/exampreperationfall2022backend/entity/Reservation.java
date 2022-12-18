package com.example.exampreperationfall2022backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate reservationDate;
    @Column
    private LocalDate rentalDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")

    private Car car;


    public Reservation(LocalDate reservationDate, Member member, Car car) {
        this.reservationDate = reservationDate;
        this.member = member;
        this.car = car;

    }

    public Reservation(LocalDate reservationDate, LocalDate rentalDate, Member  member, Car car) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
        this.member = member;
        this.car = car;
    }
}