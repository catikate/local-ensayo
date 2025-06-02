package com.example.LocalEnsayo.Service.Implem;

import com.example.LocalEnsayo.DTO.BookingDTO;
import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Model.Booking;
import com.example.LocalEnsayo.Repository.BandRepository;
import com.example.LocalEnsayo.Repository.BookingRepository;
import com.example.LocalEnsayo.Service.Interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BandRepository bandRepository;

    @Override
    public Booking createBooking(BookingDTO dto) {
        boolean overlappingBookingsFound = !bookingRepository.findOverlapingBookings(dto.getStartTime(), dto.getEndTime()).isEmpty();

        if (overlappingBookingsFound){
            throw new RuntimeException("Booking already exists");
        }

        Band band = bandRepository.findById(dto.getBandId())
                .orElseThrow(() -> new RuntimeException("Band not found"));

        Booking booking = new Booking();
        booking.setStartTime(dto.getStartTime());
        booking.setEndTime(dto.getEndTime());
        booking.setBand(band);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }
}


