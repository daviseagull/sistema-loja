package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.ItemResponse;

import java.util.List;

public class ItemResponseMock {

    public static ItemResponse build() {
        return ItemResponse.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build();
    }

    public static List<ItemResponse> buildList() {
        return List.of(ItemResponse.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build());
    }

}
