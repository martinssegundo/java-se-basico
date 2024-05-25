package org.example.view;

import org.example.services.CreditoEmConta;
import org.example.services.DebitoEmConta;
import org.example.services.OperacaoConta;
import org.example.services.SaldoConta;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUsuario {

    public BigDecimal lerValorUsuario(Scanner sc, int operacao){
        String operacaoDescricao = null;
        switch (operacao) {
            case 1 -> operacaoDescricao = "Saque";
            case 2 -> operacaoDescricao = "Deposito";
            case 3 -> operacaoDescricao = "Saldo";
        }
        if(operacao != 3){
            System.out.println(String.format("Qual o valor para %s", operacaoDescricao));
            return sc.nextBigDecimal();
        }
        return null;
    }
}
