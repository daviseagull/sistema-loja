package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ItemDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7282080627778497789L;

    @Schema(
            name = "code",
            description = "Item's code.",
            example = "875ABF4543",
            required = true
    )
    @NotBlank
    private String code;

    @Schema(
            name = "name",
            description = "Item's name.",
            example = "Arroz 5KG",
            required = true
    )
    @NotBlank
    private String name;

    @Schema(
            name = "price",
            description = "Item's price.",
            example = "21.40",
            required = true
    )
    @NotNull
    private Double price;

    @Schema(
            name = "quantity",
            description = "Item's quantity.",
            example = "100",
            required = true
    )
    @Min(1)
    private Integer quantity;


}
