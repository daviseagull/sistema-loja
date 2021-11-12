package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Customer;

public class ClienteMock {

    public static Customer build() {
        return Customer.builder()
                .cpf("1234")
                .name("Teste 1")
                .build();
    }

}
