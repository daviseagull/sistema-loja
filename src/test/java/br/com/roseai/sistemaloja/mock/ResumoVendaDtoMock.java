package br.com.roseai.sistemaloja.mock;

import br.com.roseai.sistemaloja.model.Cliente;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;

import java.util.List;

public class ResumoVendaDtoMock {

    public static final Cliente CLIENTE = ClienteMock.build();

    public static ResumoVendaDto build() {

        return ResumoVendaDto.builder()
                .cpf(CLIENTE.getCpf())
                .nome(CLIENTE.getNome())
                .id("1234")
                .valorTotal(12.34)
                .build();
    }

    public static List<ResumoVendaDto> buildList() {

        return List.of(ResumoVendaDto.builder()
                .cpf(CLIENTE.getCpf())
                .nome(CLIENTE.getNome())
                .id("1234")
                .valorTotal(12.34)
                .build());
    }
}
