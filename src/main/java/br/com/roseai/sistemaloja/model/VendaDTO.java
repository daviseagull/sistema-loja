package br.com.roseai.sistemaloja.model;

import br.com.roseai.sistemaloja.entity.Item;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class VendaDTO {

    private String id;

    private Cliente cliente;

    private Double valorTotal;

    private List<Item> itens;

}