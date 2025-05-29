package com.maricel.api.LojaDoSeuManoel.util;

import com.maricel.api.LojaDoSeuManoel.model.Caixa;
import com.maricel.api.LojaDoSeuManoel.model.Produto;

public class LojaUtil {
    public static double calcularVolume(Caixa caixa) {
        return caixa.altura() * caixa.largura() * caixa.comprimento();
    }

    public static boolean produtoCabeNaCaixa(Produto produto, Caixa caixa) {
        return produto.altura() <= caixa.altura() &&
                produto.largura() <= caixa.largura() &&
                produto.comprimento() <= caixa.comprimento();
    }
}
