package com.maricel.api.LojaDoSeuManoel.model;

import java.util.List;

public record PedidoSaida(int pedidoId, List<CaixaSaida> caixas) {}
