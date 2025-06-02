package com.example.LocalEnsayo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Backline> backline;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public List<Backline> getBackline() {
        return backline;
    }

    public void setBackline(List<Backline> backline) {
        this.backline = backline;
    }

    @Override
    public String toString() {
        return "BandMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", band=" + band +
                ", backline=" + backline +
                '}';
    }
}

