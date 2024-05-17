package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, BigDecimal> conta = new HashMap<>();
    private static String nuemroConta;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        carregaContas();
        do {
            nuemroConta = escolhaMenuPrincipal(sc);
            var opcaoConta = 0;
            System.out.println("Numero da conta " + nuemroConta);
            if(nuemroConta != null && !nuemroConta.equals("0"))
                do {
                    opcaoConta = escolhaOperacao(sc);
                    System.out.println("Opção escolhida" + opcaoConta);
                    if(opcaoConta != 0)
                        switch (opcaoConta) {
                            case 1 -> debitaConta(nuemroConta, lerValorUsado(sc, "Saque"));
                            case 2 -> creditaConta(nuemroConta, lerValorUsado(sc, "Deposito"));
                            case 3 -> saldoConta(nuemroConta);
                            default -> System.out.println("Operação invalida");
                        }
                }while (opcaoConta != 0);
        } while (!nuemroConta.equals("0"));
        System.out.println("Obrigado por usar nosso serviço");
    }

    private static void carregaContas(){
        conta.put("1", new BigDecimal(10000));
        conta.put("2", new BigDecimal(20000));
        conta.put("3", new BigDecimal(30000));
    }


    private static String escolhaMenuPrincipal(Scanner sc){
        System.out.println("Bem vindo ao Nosso Banco");
        System.out.println("Digite o numero da sua conta: ");
        System.out.println("0 -> para sair");
        var contaDigitada = sc.next();
        var contaRecuperada = conta.get(contaDigitada);
        if(contaDigitada.equals("0") || contaRecuperada != null)
            return contaDigitada;
        return "erro";
    }

    private static int escolhaOperacao(Scanner sc){
        System.out.println("Operações disponiveis para sua conta: ");
        System.out.println("0 -> Sair");
        System.out.println("1 -> Saque");
        System.out.println("2 -> Deposito");
        System.out.println("3 -> Saldo");

        return sc.nextInt();
    }

    private static BigDecimal lerValorUsado(Scanner sc, String operacao){
        System.out.println(String.format("Qual o valor para %s", operacao));
        return sc.nextBigDecimal();
    }

    private static void saldoConta(String numeroConta){
        System.out.println(String.format("Seu saudo atual é de: %.2f", conta.get(numeroConta)));
    }

    private static void creditaConta(String numeroConta, BigDecimal valor){
        if(valor.signum() == -1){
            System.out.println("Não se pode creditar valor negativo");
            return;
        }
        var valorConta = conta.get(numeroConta);
        var valorAtual = valorConta.add(valor);
        conta.put(numeroConta, valorAtual);
    }

    private static void debitaConta(String numeroConta, BigDecimal valor){
        var valorConta = conta.get(numeroConta);
        var valorAtual = valorConta.subtract(valor);
        if(valorAtual.signum() == -1){
            System.out.println("O saldo é insuficiente");
            return;
        }

        conta.put(numeroConta, valorAtual);
    }

}
