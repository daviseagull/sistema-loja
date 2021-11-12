package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Customer;
import br.com.roseai.sistemaloja.model.SaleSummaryDto;

import java.util.List;

public class SaleSummaryDtoMock {

    public static final Customer CUSTOMER = ClienteMock.build();

    public static SaleSummaryDto build() {

        return SaleSummaryDto.builder()
                .cpf(CUSTOMER.getCpf())
                .name(CUSTOMER.getName())
                .id("1234")
                .totalPrice(12.34)
                .build();
    }

    public static List<SaleSummaryDto> buildList() {

        return List.of(SaleSummaryDto.builder()
                .cpf(CUSTOMER.getCpf())
                .name(CUSTOMER.getName())
                .id("1234")
                .totalPrice(12.34)
                .build());
    }
}
