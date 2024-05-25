package org.example.exceptions;

public class OperacaoNaoRealizadaException extends RuntimeException {
    public OperacaoNaoRealizadaException(String mensagem) {
        super(mensagem);
    }
}
