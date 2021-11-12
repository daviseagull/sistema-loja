package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.exception.BadRequestException;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleResponse;
import br.com.roseai.sistemaloja.model.SaleSummaryResponse;
import br.com.roseai.sistemaloja.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sale/v1")
@RequiredArgsConstructor
public class SaleControllerImpl implements SaleController {

    private final SaleService saleService;

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getSale(@PathVariable String id) {
        //TODO: Retornar os objetos dos itens
        if (StringUtils.isBlank(id))
            throw new BadRequestException("Id não pode ser nulo.");

        return ResponseEntity.ok(saleService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<SaleSummaryResponse>> getSaleSummaryList() {
        return ResponseEntity.ok(saleService.getSaleSummaryList());
    }

    @PostMapping("")
    public ResponseEntity<String> createSale(@Valid @RequestBody SaleDto saleDto) {
        saleService.save(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
