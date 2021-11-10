package br.com.roseai.sistemaloja.model;

import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Cliente {

    private String cpf;

    private String nome;

}