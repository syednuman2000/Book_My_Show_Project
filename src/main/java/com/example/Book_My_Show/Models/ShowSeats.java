package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private int price;
    private String seatNo;
    @UpdateTimestamp
    private Date bookedAt;
    @Enumerated(value = EnumType.STRING)
    private SeatTypes seatType;
    @ManyToOne
    @JoinColumn
    private Show show;
}
