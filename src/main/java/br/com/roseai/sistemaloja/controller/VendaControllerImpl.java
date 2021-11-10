package br.com.roseai.sistemaloja.controller;

import br.com.roseai.sistemaloja.model.ResumoVendaDTO;
import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.model.VendaDTO;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("venda/v1")
@RequiredArgsConstructor
public class VendaControllerImpl implements VendaController {

    private final VendaService vendaService;

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVenda(@PathVariable String id) {
        var vendaOpt = vendaService.findById(id);
        if (vendaOpt.isPresent()) {
            var venda = vendaOpt.get();
            return ResponseEntity.ok(venda);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResumoVendaDTO>> getResumoVendas() {
        return ResponseEntity.ok(vendaService.getResumoVendas());
    }

    @PostMapping("")
    public ResponseEntity<String> createVenda(@RequestBody VendaDTO venda) {
        var createdVenda = vendaService.save(venda);
        return ResponseEntity.created(URI.create("/venda/" + createdVenda.getId())).build();
    }

}
