package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Builder
public class ItemDTO {

    @Id
    @Schema(
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
