package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class SaleSummaryResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6428679363338689247L;

    @Schema(
            name = "id",
            description = "Código único da venda.",
            example = "543234",
            required = true
    )
    private String id;

    @Schema(
            name = "name",
            description = "Nome do cliente que realizou a venda.",
            required = true
    )
    private String name;

    @Schema(
            name = "cpf",
            description = "CPF do cliente que realizou a venda.",
            required = true
    )
    private String cpf;

    @Schema(
            name = "totalPrice",
            description = "Valor total da venda.",
            example = "210.53",
            required = true
    )
    private Double totalPrice;

    @Schema(
            name = "creationDate",
            description = "Data de criação da venda.",
            example = "20/10/2021",
            required = true
    )
    private String creationDate;

}
