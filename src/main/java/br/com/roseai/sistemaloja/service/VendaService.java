package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.ResumoVendaDTO;
import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.entity.VendaDTO;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    List<ResumoVendaDTO> getResumoVendas();

    Venda save(VendaDTO venda);

    Optional<Venda> findById(String id);

}
