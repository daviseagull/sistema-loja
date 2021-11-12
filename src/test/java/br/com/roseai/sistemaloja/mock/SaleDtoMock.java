package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.SaleDto;

import java.util.List;

public class SaleDtoMock {

    public static SaleDto build() {
        return br.com.roseai.sistemaloja.model.SaleDto.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build();
    }

}
