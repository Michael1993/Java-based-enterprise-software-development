package com.example.sportsbetting.domain;

public enum EventType {
    FOOTBALLMATCH,
    TENNISMATCH;

    private String type;

    EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    EventType() {

    }

}

