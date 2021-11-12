package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Sale;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleSummaryDto;

import java.util.List;

public interface SaleService {

    List<SaleSummaryDto> getSaleSummaryList();

    Sale save(SaleDto venda);

    Sale findById(String id);

}
