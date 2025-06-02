package com.example.LocalEnsayo.Controller.Implem;


import com.example.LocalEnsayo.DTO.BookingDTO;
import com.example.LocalEnsayo.Model.Booking;
import com.example.LocalEnsayo.Service.Implem.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody BookingDTO booking) {
        return bookingService.createBooking(booking);
    }

}
