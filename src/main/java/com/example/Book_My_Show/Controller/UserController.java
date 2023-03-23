package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserEntryDto userEntryDto) {
        try{
            String result = userService.createUser(userEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>("User could not be added!", HttpStatus.BAD_REQUEST);
        }
    }
}
