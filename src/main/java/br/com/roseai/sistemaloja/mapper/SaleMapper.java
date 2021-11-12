package br.com.roseai.sistemaloja.mapper;

import br.com.roseai.sistemaloja.entity.Sale;
import br.com.roseai.sistemaloja.model.SaleDto;
import br.com.roseai.sistemaloja.model.SaleSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "creationDate", ignore = true)
    Sale toVenda(SaleDto saleDto);

    @Mapping(target = "cpf", source = "customer.cpf")
    @Mapping(target = "name", source = "customer.name")
    SaleSummaryDto toResumoVendaDto(Sale sale);

    List<SaleSummaryDto> toResumoVendaDtos(List<Sale> sales);
}


