package com.ecommerce.app.apresentation.dto.response;

import com.ecommerce.app.domain.entity.Pedido;

public record ItemPedidoResponseDTO (
        Long id,
        String nome,
        Long pedidoId
){
}
