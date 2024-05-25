package org.example.strategy;

import org.example.services.CreditoEmConta;
import org.example.services.DebititaConsignado;
import org.example.services.DebitoEmConta;
import org.example.services.OperacaoConta;
import org.example.services.SaldoConta;

import java.math.BigDecimal;

public class RealizarOperacao {

    public void realizaOperacao(int operacao, String numeroConta, BigDecimal valor){
        OperacaoConta operacaoEscolhida = escolheOperacao(operacao);
        if(operacaoEscolhida != null)
            operacaoEscolhida.executaOperacao(numeroConta, valor);
    }

    public OperacaoConta escolheOperacao(int operacao){
        OperacaoConta operacaoEscolhida = null;
        switch (operacao) {
            case 1 -> operacaoEscolhida = new DebitoEmConta();
            case 2 -> operacaoEscolhida = new CreditoEmConta();
            case 3 -> operacaoEscolhida = new SaldoConta();
            case 4 -> operacaoEscolhida = new DebititaConsignado();
            default -> System.out.println("Operação invalida");
        }
        return operacaoEscolhida;
    }
}
