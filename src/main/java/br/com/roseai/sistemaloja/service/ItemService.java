package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemDto> getResumoEstoque();

    Optional<Item> findById(String itemId);

    Item save(ItemDto venda);

    void update(String id, ItemDto item);

    void delete(String itemId);

}
