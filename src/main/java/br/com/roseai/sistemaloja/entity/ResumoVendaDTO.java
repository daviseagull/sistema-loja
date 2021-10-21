package br.com.roseai.sistemaloja.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumoVendaDTO {

    private String id;

    private String nome;

    private String cpf;

    private Double valorTotal;

    private String data;

}
