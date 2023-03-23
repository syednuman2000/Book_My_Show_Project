package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show.Models.Show;

public class ShowConverter {
    public static Show convertEntryDtoToShow(ShowEntryDto showEntryDto){
        Show show = Show.builder().showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();

        return show;
    }
}
