package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Controller.UserController;
import com.example.Book_My_Show.Converters.UserConverter;
import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String createUser(UserEntryDto userEntryDto){
        User user = UserConverter.convertEntryDtoToUser(userEntryDto);

        userRepository.save(user);
        return "User Created Successfully!";
    }
}
