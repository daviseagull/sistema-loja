package br.com.roseai.sistemaloja.entity;

import br.com.roseai.sistemaloja.model.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document
public class Venda implements Serializable {

    @Id
    private String id;

    private Cliente cliente;

    private Double valorTotal;

    private List<Item> itens;

    private LocalDateTime dataCriacao;

}
