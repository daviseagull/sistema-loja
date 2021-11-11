package br.com.roseai.sistemaloja.model;

import br.com.roseai.sistemaloja.entity.Item;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class VendaDto implements Serializable {

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
    private Cliente cliente;

    @Schema(
            name = "valorTotal",
            description = "Valor total da venda.",
            example = "210.53",
            required = true
    )
    private Double valorTotal;

    @ArraySchema(schema = @Schema(
            name = "itens",
            description = "Array com os itens da venda.",
            required = true
    ))
    private List<Item> itens;

    @Schema(
            name = "formaPagamento",
            description = "Forma de pagamento realizada na venda.",
            example = "210.53",
            required = true
    )
    private String formaPagamento;

}