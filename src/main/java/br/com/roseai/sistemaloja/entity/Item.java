package br.com.roseai.sistemaloja.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Item {

    @Id
    private String codigo;

    private String nome;

    private Double preco;

    private Integer quantidade;

    private LocalDateTime dataCriacao;
}
