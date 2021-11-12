package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDto;
import br.com.roseai.sistemaloja.model.ItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ItemController {

    @Operation(
            summary = "Endpoint used to return all items in inventory.",
            responses = {
                    @ApiResponse(
                            description = "Data obtained successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Item.class))
                            )
                    )
            }
    )
    public ResponseEntity<List<ItemResponse>> getInventory();

    @Operation(
            summary = "Endpoint used to return all active items..",
            responses = {
                    @ApiResponse(
                            description = "Data obtained successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Item.class))
                            )
                    )
            }
    )
    public ResponseEntity<List<ItemResponse>> getActiveItems();

    @Operation(
            summary = "Endpoint used to create an item.",
            responses = {
                    @ApiResponse(
                            description = "Item created successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> createItem(@RequestBody ItemDto item);

    @Operation(
            summary = "Endpoint used to update an item.",
            responses = {
                    @ApiResponse(
                            description = "Item updated succesfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody ItemDto item);

    @Operation(
            summary = "Endpoint used to delete an item.",
            responses = {
                    @ApiResponse(
                            description = "Item excluido com sucesso.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> deleteItem(@PathVariable String id);
}
