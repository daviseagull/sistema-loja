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
import java.util.Optional;

@RestController
@RequestMapping("venda/v1")
@RequiredArgsConstructor
public class VendaControllerImpl implements VendaController {

    private final VendaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVenda(@PathVariable String id) {
        Optional<Venda> vendaOpt = service.findById(id);
        if (vendaOpt.isPresent()) {
            Venda venda = vendaOpt.get();
            return ResponseEntity.ok(venda);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResumoVendaDTO>> getResumoVendas() {
        return ResponseEntity.ok(service.getResumoVendas());
    }

    @PostMapping("")
    public ResponseEntity<String> createVenda(@RequestBody VendaDTO venda) {
        Venda createdVenda = service.save(venda);
        return ResponseEntity.created(URI.create("/venda/" + createdVenda.getId())).build();
    }

}
