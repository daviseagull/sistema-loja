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
            description = "Sale's id.",
            example = "543234",
            required = true
    )
    private String id;

    @Schema(
            name = "name",
            description = "Customer's name.",
            required = true
    )
    private String name;

    @Schema(
            name = "cpf",
            description = "Customer's CPF.",
            required = true
    )
    private String cpf;

    @Schema(
            name = "totalPrice",
            description = "Sale's total price.",
            example = "210.53",
            required = true
    )
    private Double totalPrice;

    @Schema(
            name = "creationDate",
            description = "Creation date of the sale.",
            example = "20/10/2021",
            required = true
    )
    private String creationDate;

}
