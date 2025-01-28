package com.github.grangercarty.primaldawn.controller;

import com.github.grangercarty.primaldawn.mapper.DinosaurRowMapper;
import com.github.grangercarty.primaldawn.model.Dinosaur;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DinosaurController {

    private final JdbcClient jdbcClient;

    public DinosaurController (JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Bean
    public DinosaurRowMapper getDinosaurRowMapperBean() {
        return new DinosaurRowMapper();
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

    @PostMapping("/dinosaur")
    public void postDino(@RequestBody Dinosaur dinosaur) {
        jdbcClient.sql("insert into dinosaur (id, name, weight, height, food) values (?,?,?,?,?)")
                .param(dinosaur.getId())
                .param(dinosaur.getName())
                .param(dinosaur.getWeight())
                .param(dinosaur.getHeight())
                .param(dinosaur.getFood())
                .update();
    }

    @GetMapping("/dinosaurs")
    public List<Dinosaur> getAllDinosaurs() {
        return jdbcClient.sql("select * from dinosaur").query(getDinosaurRowMapperBean()).list();
    }
}
