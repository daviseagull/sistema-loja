package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Customer;

public class ClienteMock {

    public static final String CPF = "1234";
    public static final String NAME = "Teste 1";

    public static Customer build() {
        return Customer.builder()
                .cpf(CPF)
                .name(NAME)
                .build();
    }

}
