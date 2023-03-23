package com.example.Book_My_Show.EntryDtos;

import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String name;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;
}
