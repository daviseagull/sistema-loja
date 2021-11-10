package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ResumoVendaDTO {

    @Schema(
            name = "id",
            description = "Código único da venda.",
            example = "543234",
            required = true
    )
    private String id;

    @Schema(
            name = "nome",
            description = "Nome do cliente que realizou a venda.",
            required = true
    )
    private String nome;

    @Schema(
            name = "cpf",
            description = "CPF do cliente que realizou a venda.",
            required = true
    )
    private String cpf;

    @Schema(
            name = "valorTotal",
            description = "Valor total da venda.",
            example = "210.53",
            required = true
    )
    private Double valorTotal;

    @Schema(
            name = "dataCriacao",
            description = "Data de criação da venda.",
            example = "20/10/2021",
            required = true
    )
    private String data;

}
