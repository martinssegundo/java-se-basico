package org.example.services;

import org.example.model.Conta;
import org.example.repositorios.RepositorioConta;

import java.math.BigDecimal;

public class SaldoConta implements OperacaoConta{
    RepositorioConta repositorioConta;

    public SaldoConta() {
        this.repositorioConta = RepositorioConta.getInstance();
    }

    @Override
    public void executaOperacao(String numeroConta, BigDecimal valor) {
        Conta contaACreitarValor = repositorioConta.buscaContaPorNumeroConta(numeroConta);
        contaACreitarValor.verificaSaldo();
    }
}
