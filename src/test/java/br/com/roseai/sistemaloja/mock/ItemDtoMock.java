package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.ItemDto;

import java.util.List;

public class ItemDtoMock {

    public static ItemDto build(){
        return ItemDto.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build();
    }

    public static List<ItemDto> buildList(){
        return List.of(ItemDto.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build());
    }

}
