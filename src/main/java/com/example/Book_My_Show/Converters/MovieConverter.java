package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show.Models.Movie;

public class MovieConverter {
    public static Movie convertEntryDtoToMovie(MovieEntryDto movieEntryDto) {
        Movie movie = Movie.builder().name(movieEntryDto.getName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage()).build();

        return movie;
    }
}
