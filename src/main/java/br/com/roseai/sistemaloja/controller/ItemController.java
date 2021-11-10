package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDTO;
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

    @Operation (
            summary = "Endpoint para retorno de um item.",
            responses = {
                    @ApiResponse (
                            description = "Dados obtidos com sucesso.",
                            responseCode = "200",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema (implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<Item> getItem(@PathVariable String id);

    @Operation (
            summary = "Endpoint para retorno de todos itens.",
            responses = {
                    @ApiResponse (
                            description = "Dados obtidos com sucesso.",
                            responseCode = "200",
                            content = @Content (
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema (implementation = Item.class))
                            )
                    )
            }
    )
    public ResponseEntity<List<Item>> getItens();

    @Operation (
            summary = "Endpoint para criação de um item.",
            responses = {
                    @ApiResponse (
                            description = "Item criado com sucesso.",
                            responseCode = "200",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema (implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> createItem(@RequestBody Item item);

    @Operation (
            summary = "Endpoint para atualização de um item.",
            responses = {
                    @ApiResponse (
                            description = "Item atualizado com sucesso.",
                            responseCode = "200",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema (implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody Item item);

    @Operation (
            summary = "Endpoint para exclusão de um item.",
            responses = {
                    @ApiResponse (
                            description = "Item excluido com sucesso.",
                            responseCode = "200",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema (implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> deleteItem(@PathVariable String id);
}
