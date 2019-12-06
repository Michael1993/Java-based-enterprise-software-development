package com.example.sportsbetting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sportsbetting.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    public List<User> findAll();

    public List<User> findByEmailIs(String email);

}
