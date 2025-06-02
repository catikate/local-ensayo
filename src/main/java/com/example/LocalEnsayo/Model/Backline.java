package com.example.LocalEnsayo.Model;

import jakarta.persistence.*;

@Entity
public class Backline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Member owner;

    @ManyToOne
    @JoinColumn(name = "on_loan_to")
    private Member onLoanTo;

    public Backline() {
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

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public Member getOnLoanTo() {
        return onLoanTo;
    }

    public void setOnLoanTo(Member onLoanTo) {
        this.onLoanTo = onLoanTo;
    }

    @Override
    public String toString() {
        return "Backline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", onLoanTo=" + onLoanTo +
                '}';
    }
}
