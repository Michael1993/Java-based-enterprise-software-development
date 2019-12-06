package com.example.sportsbetting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Override
    public List<Player> findAll();
}
