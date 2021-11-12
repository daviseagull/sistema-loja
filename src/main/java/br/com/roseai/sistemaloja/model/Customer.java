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
            description = "Customer's CPF.",
            required = true
    )
    private String cpf;

    @Schema(
            name = "name",
            description = "Customer's name.",
            required = true
    )
    private String name;

}