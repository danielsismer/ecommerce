package com.ecommerce.app.application.service;

import com.ecommerce.app.application.mapper.PedidoMapper;
import com.ecommerce.app.apresentation.dto.request.PedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.PedidoResponseDTO;
import com.ecommerce.app.domain.entity.Pedido;
import com.ecommerce.app.infrastructure.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = mapper.toEntity(pedidoRequestDTO);
        return mapper.toResponse(repository.save(pedido));
    }


    public List<PedidoResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não Encontrado"));
        return mapper.toResponse(pedido);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public PedidoResponseDTO update(Long id, PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não Encontrado"));

        pedido.setDataEntrega(pedidoRequestDTO.dataEntrega());
        return mapper.toResponse(repository.save(pedido));
    }
}
