package org.example.services;

import org.example.model.Conta;
import org.example.repositorios.RepositorioConta;

import java.math.BigDecimal;

public class DebitoEmConta implements OperacaoConta{
    RepositorioConta repositorioConta;

    public DebitoEmConta() {
        this.repositorioConta = RepositorioConta.getInstance();
    }

    @Override
    public void executaOperacao(String numeroConta, BigDecimal valor) {
        Conta contaACreitarValor = repositorioConta.buscaContaPorNumeroConta(numeroConta);
        contaACreitarValor.realizaDebito(valor);
    }
}
