package br.com.roseai.sistemaloja.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Document
public class Item {

    @Id
    @Schema (
            name = "codigo",
            description = "Codigo do item.",
            example = "875ABF4543",
            required = true
    )
    private String codigo;

    @Schema (
            name = "nome",
            description = "Nome do item.",
            example = "Arroz 5KG",
            required = true
    )
    private String nome;

    @Schema (
            name = "preço",
            description = "Preço unitário do item.",
            example = "21.40",
            required = true
    )
    private Double preco;

    @Schema (
            name = "quantidade",
            description = "Quantidade do item no estoque.",
            example = "100",
            required = true
    )
    private Integer quantidade;
}
