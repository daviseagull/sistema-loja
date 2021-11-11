package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.entity.Venda;

import java.util.List;
import java.util.Optional;

public class VendaMock {

    public static Optional<Venda> buildOpt() {
        return Optional.of(Venda.builder()
                .cliente(ClienteMock.build())
                .id("1234")
                .itens(List.of(ItemMock.build()))
                .valorTotal(12.34)
                .formaPagamento("credito")
                .build());
    }

    public static Venda build() {
        return Venda.builder()
                .cliente(ClienteMock.build())
                .id("1234")
                .itens(List.of(ItemMock.build()))
                .valorTotal(12.34)
                .formaPagamento("credito")
                .build();
    }

    public static List<Venda> buildList() {
        return List.of(Venda.builder()
                .cliente(ClienteMock.build())
                .id("1234")
                .itens(List.of(ItemMock.build()))
                .valorTotal(12.34)
                .formaPagamento("credito")
                .build());
    }

}
