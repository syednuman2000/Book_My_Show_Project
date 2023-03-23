package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Models.User;

public class UserConverter {
    public static User convertEntryDtoToUser(UserEntryDto userEntryDto) {
        User user = User.builder().name(userEntryDto.getName())
                .email(userEntryDto.getEmail())
                .age(userEntryDto.getAge())
                .mobileNo(userEntryDto.getMobileNo())
                .address(userEntryDto.getAddress()).build();

        return user;
    }
}
