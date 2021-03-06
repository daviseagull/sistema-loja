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
            description = "Item's code.",
            example = "875ABF4543",
            required = true
    )
    private String code;

    @Schema(
            name = "name",
            description = "Item's name.",
            example = "Arroz 5KG",
            required = true
    )
    private String name;

    @Schema(
            name = "active",
            description = "Attribute used to filter the items that have more than 0 in quantity.",
            example = "true",
            required = true
    )
    private boolean active;

    @Schema(
            name = "price",
            description = "Item's price.",
            example = "21.40",
            required = true
    )
    private Double price;

    @Schema(
            name = "quantity",
            description = "Item's quantity in inventory.",
            example = "100",
            required = true
    )
    private Integer quantity;
}
