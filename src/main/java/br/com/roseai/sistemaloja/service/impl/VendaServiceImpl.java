package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import br.com.roseai.sistemaloja.mapper.VendaMapper;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;
import br.com.roseai.sistemaloja.repository.VendaRepository;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendaServiceImpl implements VendaService {

    private final VendaRepository repository;
    private final VendaMapper vendaMapper;

    @Override
    public Venda findById(String id) {
        return repository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(vendaNotFoundMessage(id)));
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
        return repository.save(venda);
    }

    public String vendaNotFoundMessage(String vendaId) {
        return "Venda com id " + vendaId + " não foi encontrada.";
    }
}
