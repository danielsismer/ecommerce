package com.ecommerce.app.apresentation.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDTO (
        LocalDateTime time,
        String message,
        int status,
        Map<String, String> errors
){
}
