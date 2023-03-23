package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Converters.ShowConverter;
import com.example.Book_My_Show.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show.Enums.SeatTypes;
import com.example.Book_My_Show.Models.*;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;

    public String createShow(ShowEntryDto showEntryDto){
        Show show = ShowConverter.convertEntryDtoToShow(showEntryDto);

        Movie movie = movieRepository.findById(showEntryDto.getMovieId()).get();
        Theater theater = theaterRepository.findById(showEntryDto.getTheaterId()).get();

        show.setMovie(movie);
        show.setTheater(theater);

        List<ShowSeats> showSeatsList = createShowSeats(showEntryDto, show);
        show.setShowSeatsList(showSeatsList);

        show = showRepository.save(show);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show Created Successfully!";
    }

    private List<ShowSeats> createShowSeats(ShowEntryDto showEntryDto, Show show){
        List<ShowSeats> showSeatsList = new ArrayList<>();

        List<TheaterSeat> theaterSeatList = show.getTheater().getTheaterSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeats showSeats = new ShowSeats();

            showSeats.setBooked(false);
            showSeats.setSeatNo(theaterSeat.getSeatNo());
            showSeats.setSeatType(theaterSeat.getSeatType());

            if(theaterSeat.getSeatType().equals(SeatTypes.CLASSIC)){
                showSeats.setPrice(showEntryDto.getClassicSeatPrice());
            }else{
                showSeats.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeats.setShow(show);

            showSeatsList.add(showSeats);
        }

        return showSeatsList;
    }
}
