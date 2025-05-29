package com.maricel.api.LojaDoSeuManoel.service.impl;

import com.maricel.api.LojaDoSeuManoel.exception.LojaException;
import com.maricel.api.LojaDoSeuManoel.model.*;
import com.maricel.api.LojaDoSeuManoel.repository.CaixaRepository;
import com.maricel.api.LojaDoSeuManoel.service.LojaService;
import com.maricel.api.LojaDoSeuManoel.util.LojaUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LojaServiceImpl implements LojaService {
    private final CaixaRepository caixaRepository;

    public LojaServiceImpl(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    @Override
    public Saida empacotar(Entrada entrada) throws LojaException {
        if (entrada == null || entrada.pedidos() == null || entrada.pedidos().isEmpty()) {
            throw new LojaException("Entrada inválida. Pedidos não podem ser nulos ou vazios.");
        }

        try {
            Saida saida = new Saida(entrada.pedidos().stream().map(this::empacotarPedido).toList());
            return saida;
        } catch (Exception e) {
            throw new LojaException("Erro ao empacotar pedidos.", e);
        }
    }

    private PedidoSaida empacotarPedido(Pedido pedido) {
        if (pedido == null || pedido.produtos() == null || pedido.produtos().isEmpty()) {
            try {
                throw new LojaException("Pedido inválido. Produtos não podem ser nulos ou vazios.");
            } catch (LojaException e) {
                throw new RuntimeException(e);
            }
        }
        List<CaixaSaida> caixasSaida = new ArrayList<>();
        for (Produto produto : pedido.produtos()) {
            boolean produtoEmpacotado = false;
            for (Caixa caixa : caixaRepository.getCaixas()) {
                if (LojaUtil.produtoCabeNaCaixa(produto, caixa)) {
                    CaixaSaida caixaSaida = caixasSaida.stream()
                            .filter(c -> c.caixaId().equals("Caixa " + caixaRepository.getCaixas().indexOf(caixa) + 1))
                            .findFirst()
                            .orElse(null);
                    if (caixaSaida == null) {
                        caixaSaida = new CaixaSaida("Caixa " + (caixaRepository.getCaixas().indexOf(caixa) + 1), new ArrayList<>());
                        caixasSaida.add(caixaSaida);
                    }
                    caixaSaida.produtos().add(produto.produtoId());
                    produtoEmpacotado = true;
                    break;
                }
            }
            if (!produtoEmpacotado) {
                CaixaSaida caixaSaida = new CaixaSaida(null, List.of(produto.produtoId()), "Produto não cabe em nenhuma caixa disponível.");
                caixasSaida.add(caixaSaida);
            }
        }
        return new PedidoSaida(pedido.pedidoId(), caixasSaida);
    }
}