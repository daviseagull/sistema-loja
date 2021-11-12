package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.exception.BadRequestException;
import br.com.roseai.sistemaloja.model.ItemDto;
import br.com.roseai.sistemaloja.model.ItemResponse;
import br.com.roseai.sistemaloja.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("item/v1")
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable String id) {
        if (StringUtils.isBlank(id))
            throwBadRequestException();

        return ResponseEntity.ok(itemService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItemResponse>> getInventory() {
        return ResponseEntity.ok(itemService.getInventory());
    }

    @GetMapping("/list/active")
    public ResponseEntity<List<ItemResponse>> getActiveItems() {
        return ResponseEntity.ok(itemService.getActiveItemList());
    }

    @PostMapping
    public ResponseEntity<String> createItem(@Valid @RequestBody ItemDto item) {
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id, @Valid @RequestBody ItemDto item) {
        if (StringUtils.isBlank(id))
            throwBadRequestException();

        itemService.update(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        if (StringUtils.isBlank(id))
            throwBadRequestException();
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public void throwBadRequestException() {
        throw new BadRequestException("Id não pode ser nulo.");
    }

}
