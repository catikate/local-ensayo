package com.example.LocalEnsayo.Model;

import com.example.LocalEnsayo.DTO.BookingDTO;
import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Model.Booking;
import com.example.LocalEnsayo.Repository.BandRepository;
import com.example.LocalEnsayo.Repository.BookingRepository;
import com.example.LocalEnsayo.Service.Implem.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class LocalEnsayoApplicationTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private BandRepository bandRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void overlappingBookingsNotFound() {
        long bandId = 1L;
        Band band = new Band(bandId, "fakeName", 213214L, "fake@band.com", List.of());

        when(bandRepository.findById(bandId)).thenReturn(Optional.of(band));
        when(bookingRepository.findOverlapingBookings(any(), any())).thenReturn(List.of());

        LocalDateTime startTime = LocalDateTime.of(2025, 6, 2, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 6, 3, 0, 0);

        BookingDTO dto = new BookingDTO();
        dto.setBandId(1L);
        dto.setStartTime(startTime);
        dto.setEndTime(endTime);

        Booking expectedBooking;
        expectedBooking = new Booking();
        expectedBooking.setId(1L);
        expectedBooking.setStartTime(startTime);
        expectedBooking.setEndTime(endTime);
        expectedBooking.setBand(band);

        when(bookingRepository.save(expectedBooking)).thenReturn(expectedBooking);

        Booking result = bookingService.createBooking(dto);
        assertNotNull(result);

        verify(bookingRepository).findOverlapingBookings(startTime, endTime);
    }

    @Test
    void overlappingBookingsFound() {
        long bandId = 1L;
        Band band = new Band(bandId, "fakeName", 213214L, "fake@band.com", List.of());

        when(bandRepository.findById(bandId)).thenReturn(Optional.of(band));
        when(bookingRepository.findOverlapingBookings(any(), any())).thenReturn(List.of(
                new Booking()
        ));

        assertThrowsExactly(RuntimeException.class, () -> bookingService.createBooking(new BookingDTO()));
    }
}
