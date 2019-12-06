package com.example.sportsbetting.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;

public class OutcomeBuilder {

    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public OutcomeBuilder(String description) {
        this.description = description;
        this.outcomeOdds = new ArrayList<>();
    }

    public OutcomeBuilder Bet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public OutcomeBuilder outcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
        return this;
    }

    public Outcome build() {
        Outcome outcome = new Outcome();
        outcome.setDescription(this.description);
        outcome.setBet(this.bet);
        outcome.setOutcomeOdds(this.outcomeOdds);
        return outcome;
    }
}
