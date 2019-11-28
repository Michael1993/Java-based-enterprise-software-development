package com.example.sportsbetting.builder;

import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Player;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlayerBuilder {
    String name;
    Integer accountNumber;
    BigDecimal balance;
    LocalDate birth;
    Currency currency;

    public PlayerBuilder(String name) {
        this.name = name;
    }
    public PlayerBuilder accountnumber(Integer accountNumber){
        this.accountNumber = accountNumber;
        return this;
    }

    public PlayerBuilder balance(BigDecimal balance) {

        this.balance = balance;
        return this;
    }

    public PlayerBuilder birth(LocalDate birth){
        this.balance = balance;
        return this;
    }
    public PlayerBuilder currency(Currency currency){
        this.currency = currency;
        return this;
    }

    public Player build(){

        Player player = new Player();
        player.setName(this.name);
        player.setAccountNumber(this.accountNumber);
        player.setBalance(this.balance);
        player.setBirth(this.birth);
        player.setCurrency(this.currency);

        return player;
    }

    private PlayerBuilder() {

    }
}
