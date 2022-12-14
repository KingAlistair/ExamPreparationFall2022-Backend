package com.example.exampreperationfall2022backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private Integer zip;
    @Column
    private boolean approved;
    @Column
    private Integer ranking;

    @OneToMany
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private List<Reservation> reservations;

    public Member(String firstName, String lastName, String street, String city, Integer zip, boolean approved, Integer ranking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }
}
