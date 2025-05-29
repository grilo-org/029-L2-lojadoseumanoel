package com.maricel.api.LojaDoSeuManoel.controller;

import com.maricel.api.LojaDoSeuManoel.exception.LojaException;
import com.maricel.api.LojaDoSeuManoel.model.Entrada;
import com.maricel.api.LojaDoSeuManoel.model.Saida;
import com.maricel.api.LojaDoSeuManoel.service.LojaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LojaControllerTest {

    @Mock
    private LojaService lojaService;

    @InjectMocks
    private LojaController lojaController;

    @Test
    void testEmpacotarSucesso() throws LojaException {
        // Arrange
        Entrada entrada = new Entrada(List.of()); // criar uma entrada válida
        Saida saida = new Saida(List.of()); // criar uma saída válida
        when(lojaService.empacotar(any(Entrada.class))).thenReturn(saida);

        // Act
        Saida resultado = lojaController.empacotar(entrada);

        // Assert
        assertEquals(saida, resultado);
    }

}