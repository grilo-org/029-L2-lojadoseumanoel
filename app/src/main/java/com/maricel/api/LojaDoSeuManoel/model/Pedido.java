package com.maricel.api.LojaDoSeuManoel.model;

import java.util.List;

public record Pedido(int pedidoId, List<Produto> produtos) {}
