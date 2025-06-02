package com.example.LocalEnsayo.Repository;

import com.example.LocalEnsayo.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking, Long> {
}
