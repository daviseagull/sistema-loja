package br.com.roseai.sistemaloja.serviceImpl;

import br.com.roseai.sistemaloja.mapper.SaleMapper;
import br.com.roseai.sistemaloja.mock.SaleDtoMock;
import br.com.roseai.sistemaloja.mock.SaleMock;
import br.com.roseai.sistemaloja.mock.SaleSummaryDtoMock;
import br.com.roseai.sistemaloja.repository.SaleRepository;
import br.com.roseai.sistemaloja.service.impl.ItemServiceImpl;
import br.com.roseai.sistemaloja.service.impl.SaleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaleServiceImplTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private ItemServiceImpl itemService;

    @Mock
    private SaleMapper saleMapper;

    @InjectMocks
    private SaleServiceImpl vendaService;

    @Test
    void testFindById() {
        var vendaId = "1234";
        var vendaOpt = SaleMock.buildOpt();
        var venda = SaleMock.build();

        when(saleRepository.findById(vendaId)).thenReturn(vendaOpt);

        var result = vendaService.findById(vendaId);

        assertThat(result).isEqualTo(venda);
    }

    @Test
    void testGetResumoVendas() {
        var vendas = SaleMock.buildList();
        var resumoVendas = SaleSummaryDtoMock.buildList();

        when(saleRepository.findAll()).thenReturn(vendas);
        when(saleMapper.toResumoVendaDtos(vendas)).thenReturn(resumoVendas);

        var result = vendaService.getSaleSummaryList();

        assertThat(result).isEqualTo(resumoVendas);
    }

    @Test
    void testSave() {
        var vendaDto = SaleDtoMock.build();
        var venda = SaleMock.build();
        var itemId = "1234";

        when(saleMapper.toVenda(vendaDto)).thenReturn(venda);
        doNothing().when(itemService).saveAfterSell(itemId);
        when(saleRepository.save(venda)).thenReturn(venda);

        var result = vendaService.save(vendaDto);

        assertThat(result).isEqualTo(venda);
    }
}
