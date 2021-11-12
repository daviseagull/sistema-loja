package br.com.roseai.sistemaloja.entity;

import br.com.roseai.sistemaloja.model.Cliente;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Document
public class Venda implements Serializable {

    @Id
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
            example = "credito",
            required = true
    )
    private String formaPagamento;

    @Schema(
            name = "dataCriacao",
            description = "Data de criação da venda.",
            example = "20/10/2021",
            required = true
    )
    private LocalDateTime dataCriacao;

}
