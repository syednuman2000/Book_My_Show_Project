package com.example.Book_My_Show.EntryDtos;

import com.example.Book_My_Show.Enums.ShowTypes;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {
    private LocalTime localTime;
    private LocalDate localDate;
    private ShowTypes showType;
    private int movieId;
    private int theaterId;
    private int classicSeatPrice;
    private int premiumSeatPrice;
}
