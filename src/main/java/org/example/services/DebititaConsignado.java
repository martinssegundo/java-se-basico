package org.example.services;

import org.example.repositorios.RepositorioConta;

import java.math.BigDecimal;

public class DebititaConsignado implements OperacaoConta{
    RepositorioConta repositorioConta;

    public DebititaConsignado() {
        this.repositorioConta = RepositorioConta.getInstance();
    }

    @Override
    public void executaOperacao(String numeroConta, BigDecimal valor) {
        var valorConsiginado = valor.add(valor.multiply(new BigDecimal("0,1")));
        var conta = repositorioConta.buscaContaPorNumeroConta(numeroConta);
        conta.realizaDebito(valorConsiginado);
    }
}
