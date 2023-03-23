package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int age;
    private String mobileNo;
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();
}
