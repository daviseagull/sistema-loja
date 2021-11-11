package br.com.roseai.sistemaloja.serviceImpl;

import br.com.roseai.sistemaloja.mapper.VendaMapper;
import br.com.roseai.sistemaloja.mock.ResumoVendaDtoMock;
import br.com.roseai.sistemaloja.mock.VendaMock;
import br.com.roseai.sistemaloja.repository.VendaRepository;
import br.com.roseai.sistemaloja.service.impl.VendaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VendaServiceImplTest {

    @Mock
    private VendaRepository vendaRepository;

    @Mock
    private VendaMapper vendaMapper;

    @InjectMocks
    private VendaServiceImpl vendaService;

    @Test
    void testFindById() {
        var vendaId = "1234";
        var vendaOpt = VendaMock.buildOpt();

        when(vendaRepository.findById(vendaId)).thenReturn(vendaOpt);

        var result = vendaService.findById(vendaId);

        assertThat(result).isEqualTo(vendaOpt);
    }

    @Test
    void testGetResumoVendas() {
        var vendas = VendaMock.buildList();
        var resumoVendas = ResumoVendaDtoMock.buildList();

        when(vendaRepository.findAll()).thenReturn(vendas);
        when(vendaMapper.toResumoVendaDtos(vendas)).thenReturn(resumoVendas);

        var result = vendaService.getResumoVendas();

        assertThat(result).isEqualTo(resumoVendas);
    }
}
