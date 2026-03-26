package com.ecommerce.app.apresentation.controller;

import com.ecommerce.app.application.service.ItemPedidoService;
import com.ecommerce.app.apresentation.dto.request.ItemPedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.ItemPedidoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDTO> save(@RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO){
        return ResponseEntity
                .status(201)
                .body(itemPedidoService.save(itemPedidoRequestDTO));
    }

}
