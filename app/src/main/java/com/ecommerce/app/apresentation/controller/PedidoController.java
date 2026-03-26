package com.ecommerce.app.apresentation.controller;

import com.ecommerce.app.application.service.PedidoService;
import com.ecommerce.app.apresentation.dto.request.PedidoRequestDTO;
import com.ecommerce.app.apresentation.dto.response.PedidoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO){
        return ResponseEntity
                .status(201)
                .body(pedidoService.save(pedidoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listAll(){
        return ResponseEntity
                .status(200)
                .body(pedidoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(200)
                .body(pedidoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> update(@PathVariable Long id, @RequestBody PedidoRequestDTO pedidoRequestDTO){
        return ResponseEntity
                .status(200)
                .body(pedidoService.update(id, pedidoRequestDTO));
    }

}
