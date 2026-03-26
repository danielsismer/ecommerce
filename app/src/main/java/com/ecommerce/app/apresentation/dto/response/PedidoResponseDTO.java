package com.ecommerce.app.apresentation.dto.response;

import java.time.LocalDate;

public record PedidoResponseDTO (
        Long id,
        LocalDate dataGeracao,
        LocalDate dataEntrega
) {
}
