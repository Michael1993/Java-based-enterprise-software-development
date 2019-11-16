package com.sportsbetting;

import java.util.ArrayList;
import java.util.List;

public class BetBuilder {
    String description;
    SportEvent event;
    BetType type;
    List<Outcome> outcomes;

    public BetBuilder(String description) {
        this.description = description;
        outcomes = new ArrayList<Outcome>();
    }
    public BetBuilder event(SportEvent event){
        this.event = event;
        return this;
    }
    public BetBuilder betType(BetType type){
        this.type = type;
        return this;
    }
    public BetBuilder outComes(List<Outcome> outcomes){
        this.outcomes = outcomes;
        return this;
    }

    public Bet build(){

        Bet bet = new Bet();
        bet.setDescription(this.description);
        bet.setEvent(this.event);
        bet.setType(this.type);
        bet.setOutcomes(this.outcomes);

        return bet;
    }

    private BetBuilder() {

    }
}
