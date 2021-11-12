package br.com.roseai.sistemaloja.service;

import br.com.roseai.sistemaloja.entity.Sale;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleResponse;
import br.com.roseai.sistemaloja.model.SaleSummaryResponse;

import java.util.List;

public interface SaleService {

    List<SaleSummaryResponse> getSaleSummaryList();

    Sale save(SaleDto venda);

    SaleResponse findById(String id);

}
