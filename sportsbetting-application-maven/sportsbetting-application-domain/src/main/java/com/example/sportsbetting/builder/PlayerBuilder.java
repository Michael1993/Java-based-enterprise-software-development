package com.example.sportsbetting.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Player;

public class PlayerBuilder {
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private LocalDate birth;
    private Currency currency;

    public PlayerBuilder(String name) {
        this.name = name;
    }

    public PlayerBuilder accountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public PlayerBuilder balance(BigDecimal balance) {

        this.balance = balance;
        return this;
    }

    public PlayerBuilder birth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public PlayerBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Player build() {

        Player player = new Player();
        player.setName(this.name);
        player.setAccountNumber(this.accountNumber);
        player.setBalance(this.balance);
        player.setBirth(this.birth);
        player.setCurrency(this.currency);

        return player;
    }
}
