package br.com.roseai.sistemaloja.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ItemDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7282080627778497789L;

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
