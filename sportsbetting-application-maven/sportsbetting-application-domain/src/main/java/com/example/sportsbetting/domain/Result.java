package com.example.sportsbetting.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
        //@JoinColumn(name = "result_id")
        List<Outcome> winnerOutcomes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> winnerOutcomes) {
        this.winnerOutcomes = winnerOutcomes;
    }
}
