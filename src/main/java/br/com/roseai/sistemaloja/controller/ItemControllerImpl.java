package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("item/v1")
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable String id) {
        var itemOpt = itemService.findById(id);
        if (itemOpt.isPresent()) {
            var item = itemOpt.get();
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Item>> getItens() {
        return ResponseEntity.ok(itemService.getResumoEstoque());
    }

    @PostMapping()
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        var createdItem = itemService.save(item);
        return ResponseEntity.created(URI.create("/item/" + createdItem.getCodigo())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody Item item) {
        itemService.update(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
