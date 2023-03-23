package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private int price;
    private LocalTime time;
    private LocalDate date;
    private String threaterName;
    private String bookedSeats;
    private String ticketId = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Show show;
}
