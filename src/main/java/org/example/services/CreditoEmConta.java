package org.example.services;

import org.example.exceptions.OperacaoNaoRealizadaException;
import org.example.model.Conta;
import org.example.repositorios.RepositorioConta;

import java.math.BigDecimal;

public class CreditoEmConta implements OperacaoConta{

    RepositorioConta repositorioConta;

    public CreditoEmConta() {
        this.repositorioConta = RepositorioConta.getInstance();
    }

    @Override
    public void executaOperacao(String numeroConta, BigDecimal valor) {
        Conta contaACreitarValor = repositorioConta.buscaContaPorNumeroConta(numeroConta);
        if(valor.doubleValue() < 0)
            throw new OperacaoNaoRealizadaException("O valor é negativo");
        contaACreitarValor.realizaCredito(valor);
    }
}
