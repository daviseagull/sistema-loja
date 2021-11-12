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
            name = "id",
            description = "Código único da venda.",
            example = "543234",
            required = true
    )
    private String id;

    @Schema(
            name = "cliente",
            description = "Informações do cliente.",
            required = true
    )
    private Customer customer;

    @Schema(
            name = "valorTotal",
            description = "Valor total da venda.",
            example = "210.53",
            required = true
    )
    @NotNull
    private Double totalPrice;

    @ArraySchema(schema = @Schema(
            name = "itens",
            description = "Array com os ids dos itens da venda.",
            required = true
    ))
    @NotEmpty
    private List<String> items;

    @Schema(
            name = "formaPagamento",
            description = "Forma de pagamento realizada na venda.",
            example = "credito",
            required = true
    )
    @NotBlank
    private String paymentForm;

}