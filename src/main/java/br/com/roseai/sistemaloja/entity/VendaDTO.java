package br.com.roseai.sistemaloja.entity;

import br.com.roseai.sistemaloja.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VendaDTO {

    private String id;

    private Cliente cliente;

    private Double valorTotal;

    private List<Item> itens;

}