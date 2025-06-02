package com.example.LocalEnsayo.Repository;

import com.example.LocalEnsayo.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    @Query("SELECT b FROM Booking b " +
            "WHERE :start < b.endTime AND :end > b.startTime")
    public List<Booking> findOverlapingBookings(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
