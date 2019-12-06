package com.example.sportsbetting.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;

public class WagerBuilder {
    private BigDecimal amount;
    private LocalDateTime timestampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd odd;
    private Currency currency;
    private Player player;

    public WagerBuilder(BigDecimal amount) {
        this.amount = amount;
    }

    public WagerBuilder timestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
        return this;
    }

    public WagerBuilder processed(boolean processed) {
        this.processed = processed;
        return this;
    }

    public WagerBuilder win(boolean win) {
        this.win = win;
        return this;
    }

    public WagerBuilder odd(OutcomeOdd odd) {
        this.odd = odd;
        return this;
    }

    public WagerBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public WagerBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public Wager build() {

        Wager wager = new Wager();
        wager.setAmount(this.amount);
        wager.setProcessed(this.processed);
        wager.setTimestampCreated(this.timestampCreated);
        wager.setWin(this.win);
        wager.setOdd(this.odd);
        wager.setCurrency(this.currency);
        wager.setPlayer(this.player);

        return wager;
    }
}
