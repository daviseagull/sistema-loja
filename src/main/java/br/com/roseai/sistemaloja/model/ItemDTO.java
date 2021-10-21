package br.com.roseai.sistemaloja.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDTO {

    private String codigo;

    private String nome;

    private Double preco;

    private Integer quantidade;

}
