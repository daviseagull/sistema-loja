package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import br.com.roseai.sistemaloja.mapper.VendaMapper;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;
import br.com.roseai.sistemaloja.repository.VendaRepository;
import br.com.roseai.sistemaloja.service.ItemService;
import br.com.roseai.sistemaloja.service.VendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final ItemService itemService;
    private final VendaMapper vendaMapper;

    @Override
    public Venda findById(String id) {
        return vendaRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(vendaNotFoundMessage(id)));
    }

    @Override
    public List<ResumoVendaDto> getResumoVendas() {
        var vendas = vendaRepository.findAll();

        var resumoVenda = vendaMapper.toResumoVendaDtos(vendas);

        log.info("Retornando resumo de vendas: {} ", resumoVenda);
        return resumoVenda;

    }

    @Override
    public Venda save(VendaDto vendaDTO) {
        var itens = vendaDTO.getItens();

        log.info("Subtraindo um da quantidade destes itens: {}", itens);
        itens.forEach(itemService::saveAfterSell);

        log.info("Mapeando venda para vendaDto: {}", vendaDTO);
        var venda = vendaMapper.toVenda(vendaDTO);

        log.info("Retornando venda criada: {}", venda);
        return vendaRepository.save(venda);
    }

    public String vendaNotFoundMessage(String vendaId) {
        return "Venda com id " + vendaId + " não foi encontrada.";
    }
}
