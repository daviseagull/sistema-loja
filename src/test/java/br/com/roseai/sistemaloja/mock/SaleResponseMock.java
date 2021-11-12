package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.SaleResponse;

import java.util.List;
import java.util.Optional;

public class SaleResponseMock {

    public static Optional<SaleResponse> buildOpt() {
        return Optional.of(SaleResponse.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build());
    }

    public static SaleResponse build() {
        return SaleResponse.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build();
    }

    public static List<SaleResponse> buildList() {
        return List.of(SaleResponse.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build());
    }

}
