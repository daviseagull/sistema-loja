package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;
import br.com.roseai.sistemaloja.repository.ItemRepository;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Item> getResumoEstoque() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> findById(String itemId) {
        return repository.findById(itemId);
    }

    @Override
    public Item save(ItemDTO itemDTO) {
        Item item = this.toItem(itemDTO);
        item.setDataCriacao(LocalDateTime.now());
        return repository.insert(item);
    }

    @Override
    public void update(String id, ItemDTO itemDTO) {
        Optional<Item> item = this.repository.findById(id);
        if (item.isPresent()) {
            Item updatedItem = this.toItem(itemDTO);
            updatedItem.setDataCriacao(item.get().getDataCriacao());
            this.repository.save(updatedItem);
        }
    }

    @Override
    public void delete(String itemId) {
        Optional<Item> item = this.repository.findById(itemId);
        item.ifPresent(this.repository::delete);
    }

    private Item toItem(ItemDTO itemDTO) {
        return mapper.map(itemDTO, Item.class);
    }

}
