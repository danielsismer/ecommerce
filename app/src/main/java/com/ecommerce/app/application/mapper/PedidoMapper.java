package com.ecommerce.app.application.mapper;

import com.ecommerce.app.apresentation.dto.request.PedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.PedidoResponseDTO;
import com.ecommerce.app.domain.entity.Pedido;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequestDTO pedidoRequestDTO){
        return new Pedido(
                LocalDate.now(),
                pedidoRequestDTO.dataEntrega()
        );
    }

    public PedidoResponseDTO toResponse(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDataGeraco(),
                pedido.getDataEntrega()
        );
    }
}
