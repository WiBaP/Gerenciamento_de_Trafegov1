package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record IntersecaoCadastroDTO(
        Long intersecaoId,

        @NotBlank(message = "O nome da interseção é obrigatório!")
        String nome,

        @NotNull(message = "A latitude é obrigatória!")
        @DecimalMin(value = "-90.0", message = "A latitude deve ser maior ou igual a -90.0")
        @DecimalMax(value = "90.0", message = "A latitude deve ser menor ou igual a 90.0")
        BigDecimal latitude,

        @NotNull(message = "A longitude é obrigatória!")
        @DecimalMin(value = "-180.0", message = "A longitude deve ser maior ou igual a -180.0")
        @DecimalMax(value = "180.0", message = "A longitude deve ser menor ou igual a 180.0")
        BigDecimal longitude
) {
}
