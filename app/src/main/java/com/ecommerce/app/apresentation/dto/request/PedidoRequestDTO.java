package com.ecommerce.app.apresentation.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PedidoRequestDTO (

        @JsonFormat(pattern = "dd/MM/yyyy")
        @FutureOrPresent
        LocalDate dataEntrega
){
}
