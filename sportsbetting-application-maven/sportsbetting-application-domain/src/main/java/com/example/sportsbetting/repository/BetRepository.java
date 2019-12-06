package com.example.sportsbetting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.Bet;

public interface BetRepository extends CrudRepository<Bet, Integer> {

}
