package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    List<ResumoVendaDto> getResumoVendas();

    Venda save(VendaDto venda);

    Optional<Venda> findById(String id);

}
