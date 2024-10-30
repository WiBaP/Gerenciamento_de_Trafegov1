package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate; // Importa LocalDate

public record FluxoCadastroDTO(
        Long fluxoId,

        @NotNull(message = "O ID da interseção é obrigatório!")
        Long intersecaoId,

        @NotNull(message = "A data e hora são obrigatórias!")
        LocalDate dataHora, // Altera de Timestamp para LocalDate

        @Min(value = 0, message = "A quantidade de veículos deve ser maior ou igual a 0")
        int quantidadeVeiculos
) {
}
