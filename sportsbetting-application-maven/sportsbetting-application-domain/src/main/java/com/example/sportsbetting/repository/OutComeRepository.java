package com.example.sportsbetting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.Outcome;

public interface OutComeRepository extends CrudRepository<Outcome, Integer> {
}
