package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Cliente {

    @Schema(
            name = "cpf",
            description = "CPF do cliente que realizou a venda.",
            required = true
    )
    private String cpf;

    @Schema(
            name = "nome",
            description = "Nome do cliente que realizou a venda.",
            required = true
    )
    private String nome;

}