package com.github.thallytacastrocv.citiesapi.states;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {


    @Query("SELECT state " +
            "FROM State state" +
            " WHERE state.uf = :uf")
    Optional<State> findByUf(String uf);
}
