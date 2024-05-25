package org.example;

import org.example.model.Conta;
import org.example.repositorios.RepositorioConta;
import org.example.strategy.RealizarOperacao;
import org.example.view.InputUsuario;
import org.example.view.MainMenu;
import org.example.view.MenuConta;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static RepositorioConta repositorioConta = RepositorioConta.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        MenuConta menuConta = new MenuConta();
        InputUsuario inputUsuario = new InputUsuario();
        RealizarOperacao realizarOperacao = new RealizarOperacao();
        String numeroConta = null;
        carregaContas();
        do {
            numeroConta = mainMenu.escolheOpcaoMenu(sc);
            var opcaoConta = 0;
            System.out.println("Numero da conta " + numeroConta);
            if(numeroConta != null && !numeroConta.equals("0"))
                do {
                    opcaoConta = menuConta.escolherMenuConta(sc);
                    System.out.println("Opção escolhida" + opcaoConta);
                    if(opcaoConta != 0)
                        realizarOperacao.realizaOperacao(
                                opcaoConta,
                                numeroConta,
                                inputUsuario.lerValorUsuario(sc, opcaoConta)
                        );
                }while (opcaoConta != 0);
        } while (!numeroConta.equals("0"));
        System.out.println("Obrigado por usar nosso serviço");
    }

    private static void carregaContas(){
        repositorioConta.adicionaConta(new Conta("1", new BigDecimal(10000)));
        repositorioConta.adicionaConta(new Conta("2", new BigDecimal(20000)));
        repositorioConta.adicionaConta(new Conta("3", new BigDecimal(30000)));
    }
}
