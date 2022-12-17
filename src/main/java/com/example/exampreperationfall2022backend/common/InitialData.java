package com.example.exampreperationfall2022backend.common;

import com.example.exampreperationfall2022backend.entity.Car;
import com.example.exampreperationfall2022backend.entity.Member;
import com.example.exampreperationfall2022backend.entity.Reservation;
import com.example.exampreperationfall2022backend.repository.CarRepository;
import com.example.exampreperationfall2022backend.repository.MemberRepository;
import com.example.exampreperationfall2022backend.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Configuration
public class InitialData implements CommandLineRunner {

    MemberRepository memberRepository;
    ReservationRepository reservationRepository;
    CarRepository carRepository;

    public InitialData(MemberRepository memberRepository, ReservationRepository reservationRepository, CarRepository carRepository) {
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Member member1 = new Member("John", "Smith", "Stone street 1.", "Copenhagen", 2200, true, 1);
        Member member2 = new Member("Mary", "McDonald", "Nyhavn 18.", "Copenhagen", 2350, true, 2);
        Member member3 = new Member("Adam", "Silvester", "Horse avenue 5.", "Kobe", 3200, true, 3);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        Car car1 = new Car("Ford", "Focus", 250.00, 10);
        Car car2 = new Car("Opel", "Astra", 210.00, 20);
        carRepository.save(car1);
        carRepository.save(car2);

        Reservation reservation1 = new Reservation(LocalDate.of(2022, 12, 18),
                LocalDate.of(2022, 12, 9), member1);
        Reservation reservation2 = new Reservation(LocalDate.of(2022, 12, 31),
                LocalDate.of(2022, 12, 10), member2);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
    }
}
