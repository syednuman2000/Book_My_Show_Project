package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Converters.TicketConverter;
import com.example.Book_My_Show.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show.Models.*;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.TicketRepository;
import com.example.Book_My_Show.Repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public String createTicket(TicketEntryDto ticketEntryDto) throws Exception {
        Ticket ticket = TicketConverter.convertEntryDtoToTicket(ticketEntryDto);

        if(!checkValidityOfRequestedSeats(ticketEntryDto)){
            throw new Exception("Requested seats are not available!");
        }

        Show show = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeats> showSeatsList = show.getShowSeatsList();
        List<String> requestedSeatsList = ticketEntryDto.getRequestedSeats();

        int price=0;
        for(ShowSeats showSeats : showSeatsList){
            if(requestedSeatsList.contains(showSeats.getSeatNo())){
                price += showSeats.getPrice();
                showSeats.setBooked(true);
                showSeats.setBookedAt(new Date());
            }
        }
        ticket.setPrice(price);

        ticket.setMovieName(show.getMovie().getName());
        ticket.setTime(show.getShowTime());
        ticket.setDate(show.getShowDate());
        ticket.setThreaterName(show.getTheater().getName());

        String allotedSeats = getAllotedSeatsFromRequstedSeats(requestedSeatsList);
        ticket.setBookedSeats(allotedSeats);

        User user = userRepository.findById(ticketEntryDto.getUserId()).get();

        ticket.setUser(user);
        ticket.setShow(show);

        ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);

        userRepository.save(user);
        showRepository.save(show);

        String body = "Hello"+user.getName()+"! Here is the ticket you have booked at BookMyShow.com \n"+ticket.getBookedSeats()+" are the seats that have been reserved for you at "+show.getTheater().getName()+". Time will be "+ticket.getTime()+"\nYou need to pay :"+ticket.getPrice();

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("backeendacciojob@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Here is your booked Ticket");

        javaMailSender.send(mimeMessage);

        return "Ticket Created Successfully!";
    }

    private String getAllotedSeatsFromRequstedSeats(List<String> list){
        String result = "";
        for(String s : list){
            result += s+", ";
        }
        return result.substring(0,result.length()-2);
    }

    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto){
        Show show = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeats> showSeatsList = show.getShowSeatsList();

        List<String> requstedSeatList = ticketEntryDto.getRequestedSeats();

        for(ShowSeats showSeats : showSeatsList){
            if(requstedSeatList.contains(showSeats.getSeatNo())){
                if(showSeats.isBooked()){
                    return false;
                }
            }
        }

        return true;
    }
}
