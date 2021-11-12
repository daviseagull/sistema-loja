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
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1053456475434442950L;

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
    private String name;

}