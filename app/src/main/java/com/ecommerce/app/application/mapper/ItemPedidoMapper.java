package com.ecommerce.app.application.mapper;

import com.ecommerce.app.apresentation.dto.request.ItemPedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.ItemPedidoResponseDTO;
import com.ecommerce.app.domain.entity.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedido toEntity(ItemPedidoRequestDTO itemPedidoRequestDTO){
        return new ItemPedido(
                itemPedidoRequestDTO.nome()
        );
    }

    public ItemPedidoResponseDTO toResponse(ItemPedido itemPedido){
        return new ItemPedidoResponseDTO(
                itemPedido.getId(),
                itemPedido.getNomeItem(),
                itemPedido.getPedido().getId()
        );
    }
}
