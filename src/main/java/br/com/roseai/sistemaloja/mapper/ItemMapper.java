package br.com.roseai.sistemaloja.mapper;

import br.com.roseai.sistemaloja.entity.Item;
import br.com.roseai.sistemaloja.model.ItemDto;
import br.com.roseai.sistemaloja.model.ItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto toItemDto(Item item);

    @Mapping(target = "active", constant = "true")
    Item toItem(ItemDto itemDto);

    ItemResponse toItemResponse(Item item);

    List<ItemResponse> toItemResponses(List<Item> itens);

}
