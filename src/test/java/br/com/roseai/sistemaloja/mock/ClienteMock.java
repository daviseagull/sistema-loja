package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Cliente;

public class ClienteMock {

    public static Cliente build() {
        return Cliente.builder()
                .cpf("1234")
                .nome("Teste 1")
                .build();
    }

}
