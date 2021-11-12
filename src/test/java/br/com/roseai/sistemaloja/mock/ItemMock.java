package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.entity.Item;

import java.util.List;
import java.util.Optional;

public class ItemMock {

    public static Optional<Item> buildOpt() {
        return Optional.of(Item.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build());
    }

    public static Item build() {
        return Item.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build();
    }

    public static List<Item> buildList() {
        return List.of(Item.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build());
    }

}
