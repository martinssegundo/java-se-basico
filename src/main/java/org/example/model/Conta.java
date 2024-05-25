package org.example.model;

import org.example.exceptions.OperacaoNaoRealizadaException;

import java.math.BigDecimal;

public class Conta {
    private String numeroConta;
    private BigDecimal saldo;

    public Conta(String numeroConta, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void realizaCredito(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        verificaSaldo();
    }

    public void realizaDebito(BigDecimal valor) {
        var saldoParcial = this.saldo.subtract(valor);
        if(saldoParcial.doubleValue() < 0)
            throw new OperacaoNaoRealizadaException("Valor de saldo insuficiente");
        this.saldo = saldoParcial;
        verificaSaldo();
    }

    public void verificaSaldo(){
        System.out.println(String.format("O saldo da conta %s é %.2f", numeroConta, saldo));
    }


    public String getNumeroConta() {
        return numeroConta;
    }
}
