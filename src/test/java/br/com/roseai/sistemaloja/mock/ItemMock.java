package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.entity.Item;

import java.util.List;
import java.util.Optional;

public class ItemMock {

    public static Optional<Item> buildOpt(){
        return Optional.of(Item.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build());
    }

    public static Item build(){
        return Item.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build();
    }

    public static List<Item> buildList(){
        return List.of(Item.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build());
    }

}
