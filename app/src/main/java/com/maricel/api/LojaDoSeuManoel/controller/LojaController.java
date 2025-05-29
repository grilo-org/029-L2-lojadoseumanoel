package com.maricel.api.LojaDoSeuManoel.controller;

import com.maricel.api.LojaDoSeuManoel.exception.LojaException;
import com.maricel.api.LojaDoSeuManoel.model.Entrada;
import com.maricel.api.LojaDoSeuManoel.model.Saida;
import com.maricel.api.LojaDoSeuManoel.service.LojaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loja")
public class LojaController {
    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/empacotar")
    public Saida empacotar(@RequestBody Entrada entrada) throws LojaException {
        return lojaService.empacotar(entrada);
    }
}
