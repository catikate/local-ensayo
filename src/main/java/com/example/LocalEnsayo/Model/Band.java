package com.example.LocalEnsayo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bandName;
    private Long bandPhone;
    private String bandMail;

    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL)
    private List<Member> members;

    public Band() {
    }

    public Band(Long id, String bandName, Long bandPhone, String bandMail, List<Member> members) {
        this.id = id;
        this.bandName = bandName;
        this.bandPhone = bandPhone;
        this.bandMail = bandMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Long getBandPhone() {
        return bandPhone;
    }

    public void setBandPhone(Long bandPhone) {
        this.bandPhone = bandPhone;
    }

    public String getBandMail() {
        return bandMail;
    }

    public void setBandMail(String bandMail) {
        this.bandMail = bandMail;
    }

    public List<Member> getBandMembers() {
        return members;
    }

    public void setBandMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", bandName='" + bandName + '\'' +
                ", bandPhone=" + bandPhone +
                ", bandMail='" + bandMail + '\'' +
                ", bandMembers=" + members +
                '}';
    }
}
