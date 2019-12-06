package com.example.sportsbetting.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;

public class OutcomeOddBuilder {

    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOddBuilder(BigDecimal value) {
        this.value = value;

    }

    public OutcomeOddBuilder validFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public OutcomeOddBuilder validUntil(LocalDateTime validUntil) {

        this.validUntil = validUntil;
        return this;
    }

    public OutcomeOddBuilder outcome(Outcome outcome) {

        this.outcome = outcome;
        return this;
    }

    public OutcomeOdd build() {

        OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(this.value);
        outcomeOdd.setOutcome(this.outcome);
        outcomeOdd.setValidFrom(this.validFrom);
        outcomeOdd.setValidUntil(this.validUntil);

        return outcomeOdd;
    }

    private OutcomeOddBuilder() {

    }
}
