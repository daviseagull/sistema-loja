package br.com.roseai.sistemaloja.mapper;

import br.com.roseai.sistemaloja.entity.Venda;
import br.com.roseai.sistemaloja.model.ResumoVendaDto;
import br.com.roseai.sistemaloja.model.VendaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    @Mapping(target = "dataCriacao", ignore = true)
    Venda toVenda(VendaDto vendaDto);

    @Mapping(target = "cpf", source = "venda.cliente.cpf")
    @Mapping(target = "nome", source = "venda.cliente.nome")
    @Mapping(target = "data", source = "dataCriacao")
    ResumoVendaDto toResumoVendaDto(Venda venda);

    List<ResumoVendaDto> toResumoVendaDtos(List<Venda> vendas);
}


