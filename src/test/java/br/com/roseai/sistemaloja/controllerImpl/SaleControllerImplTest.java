package br.com.roseai.sistemaloja.controllerImpl;

import br.com.roseai.sistemaloja.controller.SaleControllerImpl;
import br.com.roseai.sistemaloja.mock.SaleDtoMock;
import br.com.roseai.sistemaloja.mock.SaleMock;
import br.com.roseai.sistemaloja.mock.SaleResponseMock;
import br.com.roseai.sistemaloja.mock.SaleSummaryDtoMock;
import br.com.roseai.sistemaloja.service.SaleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SaleControllerImpl.class)
@ActiveProfiles("test")
class SaleControllerImplTest {

    @MockBean
    private SaleService saleService;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(
                        (request, response, chain) -> {
                            response.setCharacterEncoding("UTF-8");
                            chain.doFilter(request, response);
                        },
                        "/*"
                )
                .build();
    }

    @Test
    void testGetVenda() throws Exception {
        var vendaId = "1234";
        var vendaMock = SaleResponseMock.build();

        when(saleService.findById(vendaId)).thenReturn(vendaMock);

        var responseExpect = writeValueAsString(vendaMock).toCharArray();

        var response = this.mvc.perform(
                        get("/venda/v1/{id}", vendaId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().toCharArray();

        Arrays.sort(response);
        Arrays.sort(responseExpect);

        assertThat(new String(response)).isNotNull().isEqualTo(new String(responseExpect));
    }

    @Test
    void testGetResumoVendas() throws Exception {
        var resumoVendaDtos = SaleSummaryDtoMock.buildList();

        when(saleService.getSaleSummaryList()).thenReturn(resumoVendaDtos);

        var responseExpect = writeValueAsString(resumoVendaDtos).toCharArray();

        var response = this.mvc.perform(
                        get("/venda/v1/list")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().toCharArray();

        Arrays.sort(response);
        Arrays.sort(responseExpect);

        assertThat(new String(response)).isNotNull().isEqualTo(new String(responseExpect));
    }

    @Test
    void testCreateItem() throws Exception {
        var vendaDto = SaleDtoMock.build();
        var venda = SaleMock.build();

        when(saleService.save(vendaDto)).thenReturn(venda);

        this.mvc.perform(
                        post("/venda/v1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writeValueAsString(venda))
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isCreated());

    }

    private static String writeValueAsString(Object value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }

}
