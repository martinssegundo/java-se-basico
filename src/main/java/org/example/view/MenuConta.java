package org.example.view;

import java.util.Scanner;

public class MenuConta {

    public int escolherMenuConta(Scanner sc){
        this.exibirMenuConta();
        return sc.nextInt();
    }

    public void exibirMenuConta(){
        System.out.println("Operações disponiveis para sua conta: ");
        System.out.println("0 -> Sair");
        System.out.println("1 -> Saque");
        System.out.println("2 -> Deposito");
        System.out.println("3 -> Saldo");
    }
}
