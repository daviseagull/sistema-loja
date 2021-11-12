package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleResponse;
import br.com.roseai.sistemaloja.model.SaleSummaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SaleController {

    @Operation(
            summary = "Endpoint used to return an item.",
            responses = {
                    @ApiResponse(
                            description = "Data obtained successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<SaleResponse> getSale(@PathVariable String id);

    @Operation(
            summary = "Endpoint used to return sales summaries.",
            responses = {
                    @ApiResponse(
                            description = "Data obtained successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<List<SaleSummaryResponse>> getSaleSummaryList();

    @Operation(
            summary = "Endpoint used to create a sale.",
            responses = {
                    @ApiResponse(
                            description = "Data obtained successfully.",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Item.class)
                            )
                    )
            }
    )
    public ResponseEntity<String> createSale(@RequestBody SaleDto saleDto);

}
