package org.example.exceptions;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String menssagem) {
        super(menssagem);
    }
}
