package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Customer;
import br.com.roseai.sistemaloja.model.SaleSummaryResponse;

import java.util.List;

public class SaleSummaryDtoMock {

    public static final Customer CUSTOMER = ClienteMock.build();

    public static SaleSummaryResponse build() {

        return SaleSummaryResponse.builder()
                .cpf(CUSTOMER.getCpf())
                .name(CUSTOMER.getName())
                .id("1234")
                .totalPrice(12.34)
                .build();
    }

    public static List<SaleSummaryResponse> buildList() {

        return List.of(SaleSummaryResponse.builder()
                .cpf(CUSTOMER.getCpf())
                .name(CUSTOMER.getName())
                .id("1234")
                .totalPrice(12.34)
                .build());
    }
}
