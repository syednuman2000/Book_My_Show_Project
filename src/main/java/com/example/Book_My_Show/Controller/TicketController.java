package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/createTicket")
    public String createTicket(@RequestBody TicketEntryDto ticketEntryDto){
        try {
            String result = ticketService.createTicket(ticketEntryDto);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
