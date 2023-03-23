package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Converters.MovieConverter;
import com.example.Book_My_Show.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show.Models.Movie;
import com.example.Book_My_Show.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieEntryDto movieEntryDto) {
        Movie movie = MovieConverter.convertEntryDtoToMovie(movieEntryDto);

        movieRepository.save(movie);
        return "Movie Added Successfully!";
    }
}
