package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class SaleDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5272551353402780575L;

    @Schema(
            name = "customerName",
            description = "Customer's information.",
            required = true
    )
    private String customerName;

    @Schema(
            name = "customerCpf",
            description = "Customer's CPF.",
            required = true
    )
    private String customerCpf;

    @Schema(
            name = "totalPrice",
            description = "Sale's total price.",
            example = "210.53",
            required = true
    )
    @NotNull
    private Double totalPrice;

    @ArraySchema(schema = @Schema(
            name = "items",
            description = "Array of items id.",
            required = true
    ))
    @NotEmpty
    private List<String> items;

    @Schema(
            name = "paymentForm",
            description = "Payment form used in the sale.",
            example = "credito",
            required = true
    )
    @NotBlank
    private String paymentForm;

}