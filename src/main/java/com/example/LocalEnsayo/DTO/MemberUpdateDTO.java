package com.example.LocalEnsayo.DTO;

public class MemberUpdateDTO {
    private String name;
    private Long bandId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }
}
