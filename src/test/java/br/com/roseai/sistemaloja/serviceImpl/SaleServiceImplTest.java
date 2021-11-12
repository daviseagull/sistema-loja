package br.com.roseai.sistemaloja.serviceImpl;

import br.com.roseai.sistemaloja.mapper.SaleMapper;
import br.com.roseai.sistemaloja.mock.SaleDtoMock;
import br.com.roseai.sistemaloja.mock.SaleMock;
import br.com.roseai.sistemaloja.mock.SaleResponseMock;
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
        var saleId = "1234";
        var saleOpt = SaleMock.buildOpt();
        var sale = SaleMock.build();
        var saleResponse = SaleResponseMock.build();

        when(saleRepository.findById(saleId)).thenReturn(saleOpt);
        when(saleMapper.toSaleResponse(sale)).thenReturn(saleResponse);

        var result = vendaService.findById(saleId);

        assertThat(result).isEqualTo(saleResponse);
    }

    @Test
    void testGetSaleSummaryList() {
        var sales = SaleMock.buildList();
        var saleSummaryResponses = SaleSummaryDtoMock.buildList();

        when(saleRepository.findAll()).thenReturn(sales);
        when(saleMapper.toResumoVendaDtos(sales)).thenReturn(saleSummaryResponses);

        var result = vendaService.getSaleSummaryList();

        assertThat(result).isEqualTo(saleSummaryResponses);
    }

    @Test
    void testSave() {
        var saleDto = SaleDtoMock.build();
        var sale = SaleMock.build();
        var itemId = "1234";

        when(saleMapper.toVenda(saleDto)).thenReturn(sale);
        doNothing().when(itemService).saveAfterSell(itemId);
        when(saleRepository.save(sale)).thenReturn(sale);

        var result = vendaService.save(saleDto);

        assertThat(result).isEqualTo(sale);
    }
}
