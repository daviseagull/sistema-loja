package br.com.roseai.sistemaloja.controllerImpl;

import br.com.roseai.sistemaloja.controller.ItemControllerImpl;
import br.com.roseai.sistemaloja.mock.ItemDtoMock;
import br.com.roseai.sistemaloja.mock.ItemMock;
import br.com.roseai.sistemaloja.service.ItemService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ItemControllerImpl.class)
@ActiveProfiles("test")
class ItemControllerImplTest {

    @MockBean
    private ItemService itemService;

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
    void testGetItem() throws Exception {
        var itemId = "1234";
        var itemMock = ItemDtoMock.build();

        when(itemService.findById(itemId)).thenReturn(itemMock);

        var responseExpect = writeValueAsString(itemMock).toCharArray();

        var response = this.mvc.perform(
                        get("/item/v1/{id}", itemId)
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
    void testGetItens() throws Exception {
        var itensMock = ItemDtoMock.buildList();

        when(itemService.getResumoEstoque()).thenReturn(itensMock);

        var responseExpect = writeValueAsString(itensMock).toCharArray();

        var response = this.mvc.perform(
                        get("/item/v1/list")
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
        var itemDto = ItemDtoMock.build();
        var item = ItemMock.build();

        when(itemService.save(itemDto)).thenReturn(item);

        this.mvc.perform(
                        post("/item/v1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writeValueAsString(item))
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isCreated());

    }

    @Test
    void testUpdateItem() throws Exception {
        var itemDto = ItemDtoMock.build();
        var itemId = "1234";

        doNothing().when(itemService).update(itemId, itemDto);

        this.mvc.perform(
                        put("/item/v1/{id}", itemId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writeValueAsString(itemDto))
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteItem() throws Exception {
        var itemId = "1234";

        doNothing().when(itemService).delete(itemId);

        this.mvc.perform(
                        delete("/item/v1/{id}", itemId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin123"))
                )
                .andExpect(status().isNoContent());
    }

    private static String writeValueAsString(Object value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(value);
    }
}
