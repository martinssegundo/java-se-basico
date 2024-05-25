package org.example.services;

import java.math.BigDecimal;

public interface OperacaoConta {
    void executaOperacao(String numeroConta, BigDecimal valor);
}
