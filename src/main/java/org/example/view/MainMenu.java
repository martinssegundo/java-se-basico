package org.example.view;

import org.example.exceptions.ContaNaoEncontradaException;
import org.example.model.Conta;
import org.example.repositorios.RepositorioConta;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

    private RepositorioConta repositorioConta = RepositorioConta.getInstance();


    public String escolheOpcaoMenu(Scanner sc){
        this.exibaMenuPrincipal();
        var numeroConta = sc.next();
        try {
            var conta = repositorioConta.buscaContaPorNumeroConta(numeroConta);
            if(numeroConta.equals("0") || conta != null)
                return numeroConta;
        } catch (ContaNaoEncontradaException exception){
            return "erro";
        }
        return "erro";
    }

    public void exibaMenuPrincipal(){
        System.out.println("Bem vindo ao Nosso Banco");
        System.out.println("Digite o numero da sua conta: ");
        System.out.println("0 -> para sair");
    }
}
