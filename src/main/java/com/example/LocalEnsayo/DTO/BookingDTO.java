package com.example.LocalEnsayo.DTO;

import java.time.LocalDateTime;

public class BookingDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long bandId;


    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

