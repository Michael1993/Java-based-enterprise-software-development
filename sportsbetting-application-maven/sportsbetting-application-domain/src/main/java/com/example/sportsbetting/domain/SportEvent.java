package com.example.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SportEvent {
    @Id
    @GeneratedValue
    private int id;

    String title;
    //@Temporal(TemporalType.TIME)
    LocalDateTime startDate;
    //@Temporal(TemporalType.TIME)
    LocalDateTime endDate;

    //@OneToMany(fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @OneToMany(mappedBy = "sportEvent")
    @JoinColumn(name = "event_id")
    List<Bet> bets;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "result_id")
        Result result;

    @Enumerated(EnumType.STRING)
    EventType eventtype;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public EventType getEventtype() {
        return eventtype;
    }

    public void setEventtype(EventType eventtype) {
        this.eventtype = eventtype;
    }
}
