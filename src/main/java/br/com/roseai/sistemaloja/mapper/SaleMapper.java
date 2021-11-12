package br.com.roseai.sistemaloja.mapper;

import br.com.roseai.sistemaloja.entity.Sale;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleResponse;
import br.com.roseai.sistemaloja.model.SaleSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "creationDate", ignore = true)
    Sale toVenda(SaleDto saleDto);

    @Mapping(target = "cpf", source = "customer.cpf")
    @Mapping(target = "name", source = "customer.name")
    SaleSummaryResponse toResumoVendaDto(Sale sale);

    SaleResponse toSaleResponse(Sale sale);

    List<SaleSummaryResponse> toResumoVendaDtos(List<Sale> sales);
}


