package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.ShowTypes;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime showTime;
    private LocalDate showDate;
    @Enumerated(value = EnumType.STRING)
    private ShowTypes showType;
    @ManyToOne
    @JoinColumn
    Movie movie;
    @ManyToOne
    @JoinColumn
    Theater theater;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    List<ShowSeats> showSeatsList = new ArrayList<>();
}
