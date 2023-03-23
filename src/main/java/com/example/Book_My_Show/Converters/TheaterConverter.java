package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show.Models.Theater;

public class TheaterConverter {
    public static Theater convertEntryDtoToTheater(TheaterEntryDto theaterEntryDto) {
        Theater theater = Theater.builder().name(theaterEntryDto.getName())
                .location(theaterEntryDto.getLocation()).build();

        return theater;
    }
}
