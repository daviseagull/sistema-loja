package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getResumoEstoque();

    Optional<Item> findById(String itemId);

    Item save(ItemDTO venda);

    void update(String id, ItemDTO item);

    void delete(String itemId);

}