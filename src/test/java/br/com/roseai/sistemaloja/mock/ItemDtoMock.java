package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;

public class ItemDtoMock {

    public static ItemDTO build(){
        return ItemDTO.builder()
                .codigo("1234")
                .nome("Teste")
                .preco(21.0)
                .quantidade(45)
                .build();
    }

}
