package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.mapper.VendaMapper;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;
import br.com.roseai.sistemaloja.repository.VendaRepository;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;
    private final VendaMapper vendaMapper;

    @Override
    public Optional<Venda> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ResumoVendaDto> getResumoVendas() {
        var vendas = repository.findAll();

        var resumoVenda = vendaMapper.toResumoVendaDtos(vendas);

        log.info("Retornando resumo de vendas: {} ", resumoVenda);
        return resumoVenda;

    }

    @Override
    public Venda save(VendaDto vendaDTO) {
        var venda = vendaMapper.toVenda(vendaDTO);
        venda.setDataCriacao(LocalDateTime.now());
        return repository.save(venda);
    }
}
