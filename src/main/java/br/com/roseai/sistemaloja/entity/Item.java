package br.com.roseai.sistemaloja.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Document
public class Item {

    @Id
    @Schema(
            name = "code",
            description = "Codigo do item.",
            example = "875ABF4543",
            required = true
    )
    private String code;

    @Schema(
            name = "name",
            description = "Nome do item.",
            example = "Arroz 5KG",
            required = true
    )
    private String name;

    @Schema(
            name = "active",
            description = "campo usado para filtrar os itens ativos (quantidade > 0)",
            example = "true",
            required = true
    )
    private boolean active;

    @Schema(
            name = "price",
            description = "Preço unitário do item.",
            example = "21.40",
            required = true
    )
    private Double price;

    @Schema(
            name = "quantity",
            description = "Quantidade do item no estoque.",
            example = "100",
            required = true
    )
    private Integer quantity;
}
