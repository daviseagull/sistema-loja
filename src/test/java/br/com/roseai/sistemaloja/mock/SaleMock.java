package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.entity.Sale;

import java.util.List;
import java.util.Optional;

public class SaleMock {

    public static Optional<Sale> buildOpt() {
        return Optional.of(Sale.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build());
    }

    public static Sale build() {
        return Sale.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build();
    }

    public static List<Sale> buildList() {
        return List.of(Sale.builder()
                .customer(ClienteMock.build())
                .id("1234")
                .items(List.of("1234"))
                .totalPrice(12.34)
                .paymentForm("credito")
                .build());
    }

}
