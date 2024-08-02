package com.Sena_Market.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hola")
public class EjemploController {

    @GetMapping("/uu")
    public  String algo(){
        return "diegoooooo";
    }

}
