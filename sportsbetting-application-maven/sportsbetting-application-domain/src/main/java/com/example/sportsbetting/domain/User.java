package com.example.sportsbetting.domain;

import javax.persistence.Entity;

@Entity
public class User extends Player {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email, String password, Player player) {
        this.setEmail(email);
        this.setPassword(password);
        this.setPlayerParameters(player);
    }

    public void setPlayerParameters(Player player) {
        this.setAccountNumber(player.getAccountNumber());
        this.setBalance(player.getBalance());
        this.setBirth(player.getBirth());
        this.setCurrency(player.getCurrency());
        this.setId(player.getId());
        this.setName(player.getName());

    }

}
