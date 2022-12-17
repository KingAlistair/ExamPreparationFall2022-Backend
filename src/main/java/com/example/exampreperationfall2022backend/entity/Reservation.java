package com.example.exampreperationfall2022backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private LocalDate rentalDate;


    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    public Reservation(LocalDate reservationDate, LocalDate rentalDate) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }

    public Reservation(LocalDate reservationDate, LocalDate rentalDate, Member  member) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
        this.member = member;
    }
}