package com.example.sportsbetting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.SportEvent;

public interface SportEventRepository extends CrudRepository<SportEvent, Integer> {
    @Override
    List<SportEvent> findAll();
}
