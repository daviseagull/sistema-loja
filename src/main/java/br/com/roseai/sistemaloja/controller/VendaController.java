package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.model.ResumoVendaDTO;
import br.com.roseai.sistemaloja.model.VendaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VendaController {

    @Operation(
            summary = "Endpoint para retorno de uma venda.",
            responses = {
                    @ApiResponse(
                            description = "Dados obtidos com sucesso.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<Venda> getVenda(@PathVariable String id);

    @Operation(
            summary = "Endpoint para retorno dos resumos das vendas.",
            responses = {
                    @ApiResponse(
                            description = "Dados obtidos com sucesso.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<List<ResumoVendaDTO>> getResumoVendas();

    @Operation(
            summary = "Endpoint para criação de uma venda.",
            responses = {
                    @ApiResponse(
                            description = "Dados obtidos com sucesso.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> createVenda(@RequestBody VendaDTO venda);

}
