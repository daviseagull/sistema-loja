package br.com.roseai.sistemaloja.model;

import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ResumoVendaDTO {

    private String id;

    private String nome;

    private String cpf;

    private Double valorTotal;

    private String data;

}
