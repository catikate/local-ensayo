package com.example.LocalEnsayo.DTO;

import java.time.LocalDateTime;

public class BookingDTO {
    private LocalDateTime dateHour;
    private int duration;
    private Long bandId;

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }
}