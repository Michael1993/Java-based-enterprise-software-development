package com.example.sportsbetting.builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.EventType;
import com.example.sportsbetting.domain.Result;
import com.example.sportsbetting.domain.SportEvent;

public class SportEventBuilder {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;
    private EventType eventType;

    public SportEventBuilder(String title) {
        this.title = title;
        this.bets = new ArrayList<>();
    }

    public SportEventBuilder startDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public SportEventBuilder endDate(LocalDateTime endDate) {

        this.endDate = endDate;
        return this;
    }

    public SportEventBuilder bets(List<Bet> bets) {
        this.bets = bets;
        return this;
    }

    public SportEventBuilder result(Result result) {
        this.result = result;
        return this;
    }

    public SportEventBuilder eventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public SportEvent build() {

        SportEvent sportEvent = new SportEvent();
        sportEvent.setTitle(this.title);
        sportEvent.setStartDate(this.startDate);
        sportEvent.setEndDate(this.endDate);
        sportEvent.setBets(this.bets);
        sportEvent.setResult(this.result);
        sportEvent.setEventtype(this.eventType);

        return sportEvent;
    }
}
