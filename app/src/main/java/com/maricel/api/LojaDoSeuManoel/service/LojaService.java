package com.maricel.api.LojaDoSeuManoel.service;

import com.maricel.api.LojaDoSeuManoel.exception.LojaException;
import com.maricel.api.LojaDoSeuManoel.model.Entrada;
import com.maricel.api.LojaDoSeuManoel.model.Saida;

import java.util.List;

public interface LojaService {
    Saida empacotar(Entrada entrada) throws LojaException;
}
