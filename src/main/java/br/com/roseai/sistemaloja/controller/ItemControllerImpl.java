package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("item/v1")
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable String id) {
        Optional<Item> itemOpt = service.findById(id);
        if (itemOpt.isPresent()) {
            Item item = itemOpt.get();
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Item>> getItens() {
        return ResponseEntity.ok(service.getResumoEstoque());
    }

    @PostMapping()
    public ResponseEntity<String> createItem(@RequestBody ItemDTO item) {
        Item createdItem = service.save(item);
        return ResponseEntity.created(URI.create("/item/" + createdItem.getCodigo())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody ItemDTO item) {
        service.update(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
