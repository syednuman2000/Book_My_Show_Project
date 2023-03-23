package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/createShow")
    public String createShow(@RequestBody ShowEntryDto showEntryDto){
        return showService.createShow(showEntryDto);
    }
}
