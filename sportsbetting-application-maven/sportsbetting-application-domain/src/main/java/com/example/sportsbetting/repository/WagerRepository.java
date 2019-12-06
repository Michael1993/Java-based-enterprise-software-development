package com.example.sportsbetting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.Wager;

public interface WagerRepository extends CrudRepository<Wager, Integer> {
    @Override
    List<Wager> findAll();

}
