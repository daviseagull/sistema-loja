package br.com.roseai.sistemaloja.serviceImpl;

import br.com.roseai.sistemaloja.mapper.ItemMapper;
import br.com.roseai.sistemaloja.mock.ItemDtoMock;
import br.com.roseai.sistemaloja.mock.ItemMock;
import br.com.roseai.sistemaloja.mock.ItemResponseMock;
import br.com.roseai.sistemaloja.repository.ItemRepository;
import br.com.roseai.sistemaloja.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void testGetInventory() {
        var items = ItemMock.buildList();
        var itemDtos = ItemResponseMock.buildList();

        when(itemRepository.findAll()).thenReturn(items);
        when(itemMapper.toItemResponses(items)).thenReturn(itemDtos);

        var result = itemService.getInventory();

        assertThat(result).isEqualTo(itemDtos);
    }

    @Test
    void testSave() {
        var item = ItemMock.build();
        var itemDto = ItemDtoMock.build();

        when(itemRepository.insert(item)).thenReturn(item);
        when(itemMapper.toItem(itemDto)).thenReturn(item);

        var result = itemService.save(itemDto);

        assertThat(result).isEqualTo(item);
    }

//    @Test
//    void testUpdate() {
//        var itemId = "1234";
//        var itemOpt = ItemMock.buildOpt();
//        var item = ItemMock.build();
//        var itemDto = ItemDtoMock.build();
//
//        when(itemRepository.findById(itemId)).thenReturn(itemOpt);
//        when(itemRepository.save(item)).thenReturn(item);
//        when(itemMapper.toItem(itemDto)).thenReturn(item);
//
//        itemService.update(itemId, itemDto);
//
    //TODO: verificar como fazer teste de m??todo que retorna void
//
//    }
}
