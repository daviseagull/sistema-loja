package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import br.com.roseai.sistemaloja.mapper.ItemMapper;
import br.com.roseai.sistemaloja.model.ItemDto;
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
    public List<ItemDto> getResumoEstoque() {

        var itens = repository.findAll();

        log.info("Mapeando lista para itemDto: {}", itens);
        var resumoEstoque = itemMapper.toItemDtos(itens);

        log.info("Retornando lista de itens: {} ", resumoEstoque);
        return resumoEstoque;
    }

    @Override
    public List<ItemDto> getActiveItems() {
        var activeItems = repository.findAllByActiveIsTrue();

        log.info("Mapeando lista para itemDto: {}", activeItems);
        var activeItemsDto = itemMapper.toItemDtos(activeItems);

        log.info("Retornando lista de itens: {} ", activeItemsDto);
        return activeItemsDto;
    }


    @Override
    public ItemDto findById(String itemId) {
        log.info("buscando item com id: {} ", itemId);

        var item = repository.findById(itemId).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(itemNotFoundMessage(itemId)));

        return itemMapper.toItemDto(item);
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

        var item = itemMapper.toItem(findById(itemId));

        var itemNewQuantity = item.getQuantidade() - 1;

        if (itemNewQuantity == 0)
            item.setActive(false);
        
        item.setQuantidade(itemNewQuantity);

        repository.save(item);
    }

    public String itemNotFoundMessage(String itemId) {
        return "Item com id " + itemId + " não foi encontrado.";
    }

}
