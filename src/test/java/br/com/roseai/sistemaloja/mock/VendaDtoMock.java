package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.VendaDto;

import java.util.List;

public class VendaDtoMock {

    public static VendaDto build() {
        return VendaDto.builder()
                .cliente(ClienteMock.build())
                .id("1234")
                .itens(List.of(ItemDtoMock.build()))
                .valorTotal(12.34)
                .formaPagamento("credito")
                .build();
    }

}
