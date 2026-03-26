package com.ecommerce.app.application.service;

import com.ecommerce.app.application.mapper.ItemPedidoMapper;
import com.ecommerce.app.apresentation.dto.request.ItemPedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.ItemPedidoResponseDTO;
import com.ecommerce.app.domain.entity.ItemPedido;
import com.ecommerce.app.domain.entity.Pedido;
import com.ecommerce.app.infrastructure.repository.ItemPedidoRepository;
import com.ecommerce.app.infrastructure.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoMapper mapper;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoResponseDTO save(ItemPedidoRequestDTO itemPedidoRequestDTO) {

        Pedido pedido = pedidoRepository.findById(itemPedidoRequestDTO.pedidoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não Encontrado"));

        ItemPedido itemPedido = mapper.toEntity(itemPedidoRequestDTO);

        itemPedido.setPedido(pedido);

        return mapper.toResponse(itemPedidoRepository.save(itemPedido));

    }
}
