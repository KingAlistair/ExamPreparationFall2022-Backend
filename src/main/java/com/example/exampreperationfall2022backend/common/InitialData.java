package com.example.exampreperationfall2022backend.common;

import com.example.exampreperationfall2022backend.entity.Car;
import com.example.exampreperationfall2022backend.entity.Member;
import com.example.exampreperationfall2022backend.entity.Reservation;
import com.example.exampreperationfall2022backend.repository.CarRepository;
import com.example.exampreperationfall2022backend.repository.MemberRepository;
import com.example.exampreperationfall2022backend.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
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
        Member member = new Member("John","Smith", "Stone street","Copenhagen",2200,true,1);
        memberRepository.save(member);

        Car car1 = new Car("Ford", "Focus", 250.00, 10);
        Car car2 = new Car("Opel", "Astra", 210.00, 20);
        carRepository.save(car1);
        carRepository.save(car2);


        Reservation reservation1 = new Reservation(LocalDate.now(), LocalDate.now(), member, car1);
        Reservation reservation2 = new Reservation(LocalDate.now(), LocalDate.now(), member, car2);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
    }
}
