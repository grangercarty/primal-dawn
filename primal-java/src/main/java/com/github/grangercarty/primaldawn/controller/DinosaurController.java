package com.github.grangercarty.primaldawn.controller;

import com.github.grangercarty.primaldawn.model.Dinosaur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinosaurController {

    @GetMapping("/dino")
    public Dinosaur dino() {
        Dinosaur dino = new Dinosaur();
        dino.setName("T-Rex");
        dino.setHeight(300);
        dino.setFood("Anything that moves");
        dino.setLength(1200);
        dino.setWeight(4000);
        return dino;
    }
}
