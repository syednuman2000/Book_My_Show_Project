package com.example.Book_My_Show.Converters;

import com.example.Book_My_Show.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show.Models.Ticket;

public class TicketConverter {
    public static Ticket convertEntryDtoToTicket(TicketEntryDto ticketEntryDto){
        Ticket ticket = new Ticket();
        return ticket;
    }
}
