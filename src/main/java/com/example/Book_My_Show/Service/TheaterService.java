package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Converters.TheaterConverter;
import com.example.Book_My_Show.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show.Enums.SeatTypes;
import com.example.Book_My_Show.Models.Theater;
import com.example.Book_My_Show.Models.TheaterSeat;
import com.example.Book_My_Show.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterEntryDto theaterEntryDto) throws Exception {
        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
            throw new Exception("Name and Location should be valid!");
        }
        Theater theater = TheaterConverter.convertEntryDtoToTheater(theaterEntryDto);
        List<TheaterSeat> theaterSeatList = createTheaterSeats(theaterEntryDto, theater);
        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);

        return "Theater Added Successfully!";
    }

    private List<TheaterSeat> createTheaterSeats(TheaterEntryDto theaterEntryDto, Theater theater) {
        int noOfClassicSeats = theaterEntryDto.getClassicSeatCount();
        int noOfPremiumSeats = theaterEntryDto.getPremiumSeatCount();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        for(int i=1;i<=noOfClassicSeats;i++){
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(i+"C")
                    .seatType(SeatTypes.CLASSIC)
                    .theater(theater).build();

            theaterSeatList.add(theaterSeat);
        }

        for(int i=1;i<=noOfPremiumSeats;i++){
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(i+"P")
                    .seatType(SeatTypes.PREMIUM)
                    .theater(theater).build();

            theaterSeatList.add(theaterSeat);
        }

        return theaterSeatList;
    }
}
