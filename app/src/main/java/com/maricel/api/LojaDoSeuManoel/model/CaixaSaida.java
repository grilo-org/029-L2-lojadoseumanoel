package com.maricel.api.LojaDoSeuManoel.model;

import java.util.List;

public record CaixaSaida(String caixaId, List<String> produtos, String observacao) {
    public CaixaSaida(String caixaId, List<String> produtos) {
        this(caixaId, produtos, null);
    }
}
