package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;
import br.com.roseai.sistemaloja.repository.ItemRepository;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Item> getResumoEstoque() {
        var resumoEstoque = repository.findAll();
        log.info("Retornando lista de itens: {} ", resumoEstoque);
        return resumoEstoque;
    }

    @Override
    public Optional<Item> findById(String itemId) {
        log.info("buscando item com id: {} ", itemId);
        return repository.findById(itemId);
    }

    @Override
    public Item save(Item item) {
        log.info("Salvando o item: {} ", item);
        return repository.insert(item);
    }

    @Override
    public void update(String id, Item item) {
        var itemOpt = this.repository.findById(id);
        if (itemOpt.isPresent()) {
            log.info("Atualizando o item: {} ", itemOpt);
            this.repository.save(itemOpt.get());
        }
    }

    @Override
    public void delete(String itemId) {
        var itemOpt = this.repository.findById(itemId);
        if (itemOpt.isPresent()) {
            log.info("Deletando o item {}: ", itemOpt);
            this.repository.delete(itemOpt.get());
        } else {
            log.error("Item com id: {} não encontrado.", itemId);
        }
    }

    private Item toItem(ItemDTO itemDTO) {
        return mapper.map(itemDTO, Item.class);
    }

}
