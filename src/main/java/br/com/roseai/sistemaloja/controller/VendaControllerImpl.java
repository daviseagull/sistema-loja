package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.exception.BadRequestException;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("venda/v1")
@RequiredArgsConstructor
public class VendaControllerImpl implements VendaController {

    private final VendaService vendaService;

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVenda(@PathVariable String id) {
        if (StringUtils.isBlank(id))
            throw new BadRequestException("Id não pode ser nulo.");

        return ResponseEntity.ok(vendaService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResumoVendaDto>> getResumoVendas() {
        return ResponseEntity.ok(vendaService.getResumoVendas());
    }

    @PostMapping("")
    public ResponseEntity<String> createVenda(@Valid @RequestBody VendaDto venda) {
        vendaService.save(venda);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
