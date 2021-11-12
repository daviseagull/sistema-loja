package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.ItemDto;

import java.util.List;

public class ItemDtoMock {

    public static ItemDto build() {
        return ItemDto.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build();
    }

    public static List<ItemDto> buildList() {
        return List.of(ItemDto.builder()
                .code("1234")
                .name("Teste")
                .price(21.0)
                .quantity(45)
                .build());
    }

}
