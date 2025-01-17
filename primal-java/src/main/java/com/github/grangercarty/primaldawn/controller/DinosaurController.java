package com.github.grangercarty.primaldawn.controller;

import com.github.grangercarty.primaldawn.model.Dinosaur;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinosaurController {

    private final JdbcClient jdbcClient;

    public DinosaurController (JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @GetMapping("/dino")
    public Dinosaur sampleDino() {
        Dinosaur dino = new Dinosaur();
        dino.setName("T-Rex");
        dino.setId(-1);
        dino.setHeight(300);
        dino.setFood("Anything that moves");
        dino.setWeight(4000);
        return dino;
    }

    @PostMapping
    public void postDino(@RequestBody Dinosaur dinosaur) {
        jdbcClient.sql("insert into dinosaur (id, name, weight, height, food) values (?,?,?,?,?)")
                .param(dinosaur.getId())
                .param(dinosaur.getName())
                .param(dinosaur.getWeight())
                .param(dinosaur.getHeight())
                .param(dinosaur.getFood())
                .update();
    }
}
