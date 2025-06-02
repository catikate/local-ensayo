package com.example.LocalEnsayo.Service.Interfaces;

import com.example.LocalEnsayo.Model.Booking;
import com.example.LocalEnsayo.DTO.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking createBooking(BookingDTO dto);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    void deleteById(Long id);
}
