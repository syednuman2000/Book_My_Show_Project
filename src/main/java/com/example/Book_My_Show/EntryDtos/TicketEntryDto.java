package com.example.Book_My_Show.EntryDtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {
    private int showId;
    private int userId;
    private List<String> requestedSeats = new ArrayList<>();
}
