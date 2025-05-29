package com.maricel.api.LojaDoSeuManoel.repository;

import com.maricel.api.LojaDoSeuManoel.model.Caixa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CaixaRepository {
    private List<Caixa> caixas;

    public CaixaRepository() {
        caixas = new ArrayList<>();
        caixas.add(new Caixa(30, 40, 80));
        caixas.add(new Caixa(80, 50, 40));
        caixas.add(new Caixa(50, 80, 60));
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }
}
