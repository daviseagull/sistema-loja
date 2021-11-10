package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.model.ResumoVendaDTO;
import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.model.VendaDTO;
import br.com.roseai.sistemaloja.repository.VendaRepository;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;
    private final ModelMapper mapper;

    @Override
    public Optional<Venda> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ResumoVendaDTO> getResumoVendas() {
        var vendas = repository.findAll();

        var resumoVenda = vendas.stream()
                .map(this::toResumoVendaDTO)
                .toList();

        log.info("Retornando resumo de vendas: {} ", resumoVenda);
        return resumoVenda;

    }

    @Override
    public Venda save(VendaDTO vendaDTO) {
        var venda = this.toVenda(vendaDTO);
        venda.setDataCriacao(LocalDateTime.now());
        return repository.save(venda);
    }

    private ResumoVendaDTO toResumoVendaDTO(Venda venda) {
        return mapper.map(venda, ResumoVendaDTO.class);
    }

    private Venda toVenda(VendaDTO vendaDTO) {
        return mapper.map(vendaDTO, Venda.class);
    }
}
