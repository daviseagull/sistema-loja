package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getInventory();

    ItemDto findById(String itemId);

    Item save(ItemDto item);

    void saveAfterSell(String itemId);

    void update(String id, ItemDto item);

    void delete(String itemId);

    List<ItemDto> getActiveItemList();
}
