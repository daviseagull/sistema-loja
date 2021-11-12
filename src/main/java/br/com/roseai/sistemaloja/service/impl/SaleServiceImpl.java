package br.com.roseai.sistemaloja.service.impl;

import br.com.roseai.sistemaloja.entity.Sale;
import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import br.com.roseai.sistemaloja.mapper.SaleMapper;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleSummaryDto;
import br.com.roseai.sistemaloja.repository.SaleRepository;
import br.com.roseai.sistemaloja.service.ItemService;
import br.com.roseai.sistemaloja.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ItemService itemService;
    private final SaleMapper saleMapper;

    @Override
    public Sale findById(String id) {
        return saleRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new EmptyOptionalException(vendaNotFoundMessage(id)));
    }

    @Override
    public List<SaleSummaryDto> getSaleSummaryList() {
        var saleList = saleRepository.findAll();

        var saleSummaryList = saleMapper.toResumoVendaDtos(saleList);

        log.info("Retornando resumo de vendas: {} ", saleSummaryList);
        return saleSummaryList;

    }

    @Override
    public Sale save(SaleDto saleDto) {
        var itemList = saleDto.getItems();

        log.info("Subtraindo um da quantidade destes itens: {}", itemList);
        itemList.forEach(itemService::saveAfterSell);

        log.info("Mapeando venda para vendaDto: {}", saleDto);
        var sale = saleMapper.toVenda(saleDto);

        log.info("Retornando venda criada: {}", sale);
        return saleRepository.save(sale);
    }

    public String vendaNotFoundMessage(String vendaId) {
        return "Venda com id " + vendaId + " não foi encontrada.";
    }
}
