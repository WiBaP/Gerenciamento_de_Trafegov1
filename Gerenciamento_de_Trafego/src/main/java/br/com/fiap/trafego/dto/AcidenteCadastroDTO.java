package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate; // Importa LocalDate

public record AcidenteCadastroDTO(
        Long acidenteId,

        @NotNull(message = "O ID da interseção é obrigatório!")
        Long intersecaoId,

        @NotNull(message = "A data e hora são obrigatórias!")
        LocalDate dataHora,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotBlank(message = "A gravidade é obrigatória!")
        String gravidade
) {
}
