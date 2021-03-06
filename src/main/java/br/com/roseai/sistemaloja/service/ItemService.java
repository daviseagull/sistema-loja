package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDto;
import br.com.roseai.sistemaloja.model.ItemResponse;

import java.util.List;

public interface ItemService {

    List<ItemResponse> getInventory();

    Item save(ItemDto item);

    void saveAfterSell(String itemId);

    void update(String id, ItemDto item);

    void delete(String itemId);

    ItemDto findDtoById(String itemId);

    List<ItemResponse> getActiveItemList();

    ItemDto getItem(String id);
}
