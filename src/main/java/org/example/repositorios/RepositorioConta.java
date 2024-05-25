package org.example.repositorios;

import org.example.exceptions.ContaNaoEncontradaException;
import org.example.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class RepositorioConta {
    private List<Conta> contas;
    private static RepositorioConta instance;

    private RepositorioConta() {
        this.contas = new ArrayList<>();
    }

    public static RepositorioConta getInstance() {
        if(instance == null)
            instance = new RepositorioConta();
        return instance;
    }

    public void adicionaConta(Conta novaConta){
        this.contas.add(novaConta);
    }

    public Conta buscaContaPorNumeroConta(String numeroConta){
        return contas.stream()
                .filter(conta -> conta.getNumeroConta().equals(numeroConta))
                .findFirst()
                .orElseThrow(() -> new ContaNaoEncontradaException(String.format("Conta %s não encontra", numeroConta)));
    }
}
