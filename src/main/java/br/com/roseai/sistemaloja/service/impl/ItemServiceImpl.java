package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import br.com.roseai.sistemaloja.mapper.ItemMapper;
import br.com.roseai.sistemaloja.model.ItemDto;
import br.com.roseai.sistemaloja.model.ItemResponse;
import br.com.roseai.sistemaloja.repository.ItemRepository;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemResponse> getInventory() {

        var itemList = repository.findAll();

        log.info("Mapeando lista para itemDto: {}", itemList);
        var inventory = itemMapper.toItemResponses(itemList);

        log.info("Retornando lista de itens: {} ", inventory);
        return inventory;
    }

    @Override
    public ItemDto getItem(String id) {
        var item = repository.findById(id).orElseThrow(() -> new EmptyOptionalException(itemNotFoundMessage(id)));
        return itemMapper.toItemDto(item);
    }

    @Override
    public List<ItemResponse> getActiveItemList() {
        var activeItemList = repository.findAllByActiveIsTrue();

        log.info("Mapeando lista para itemDto: {}", activeItemList);
        var itemDtoList = itemMapper.toItemResponses(activeItemList);

        log.info("Retornando lista de itens: {} ", itemDtoList);
        return itemDtoList;
    }

    @Override
    public Item save(ItemDto itemDto) {
        log.info("Mapeando o itemDto para item: {} ", itemDto);
        var item = itemMapper.toItem(itemDto);

        item.setActive(true);

        log.info("Salvando o item: {} ", item);
        return repository.insert(item);
    }

    @Override
    public void update(String itemId, ItemDto itemDto) {
        var item = this.repository.findById(itemId).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(itemNotFoundMessage(itemId)));
        log.info("Atualizando o item: {} para: {}", item, itemDto);
        this.repository.save(itemMapper.toItem(itemDto));
    }

    @Override
    public void delete(String itemId) {
        var item = this.repository.findById(itemId).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(itemNotFoundMessage(itemId)));
        log.info("Deletando o item {}: ", item);
        this.repository.delete(item);
    }

    @Override
    public void saveAfterSell(String itemId) {

        var item = itemMapper.toItem(findDtoById(itemId));

        var itemNewQuantity = item.getQuantity() - 1;

        if (itemNewQuantity == 0)
            item.setActive(false);

        item.setQuantity(itemNewQuantity);

        repository.save(item);
    }

    @Override
    public ItemDto findDtoById(String itemId) {
        log.info("buscando item com id: {} ", itemId);

        var item = repository.findById(itemId).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(itemNotFoundMessage(itemId)));

        return itemMapper.toItemDto(item);
    }

    public String itemNotFoundMessage(String itemId) {
        return "Item com id " + itemId + " não foi encontrado.";
    }

}
