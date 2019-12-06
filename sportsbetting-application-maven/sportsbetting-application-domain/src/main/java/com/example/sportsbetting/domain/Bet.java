package com.example.sportsbetting.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Bet {
    @Id
    @GeneratedValue
    private int id;

    String description;

    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "event_id")
        //@Cascade(org.hibernate.annotations.CascadeType.MERGE)
        SportEvent event;

    @Enumerated(EnumType.STRING)
    BetType type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToMany(fetch = FetchType.LAZY)
        //@JoinColumn(name = "bet_id")
        List<Outcome> outcomes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
