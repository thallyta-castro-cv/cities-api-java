package com.github.thallytacastrocv.citiesapi.states;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {
    private final StateRepository repository;

    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    @GetMapping(value = "/{uf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity stateByUf(@PathVariable String uf) {
        Optional<State> optional = repository.findByUf(uf.toUpperCase());

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else
            return ResponseEntity.notFound().build();
    }
}
