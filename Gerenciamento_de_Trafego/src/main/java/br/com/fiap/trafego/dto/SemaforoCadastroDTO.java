package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SemaforoCadastroDTO(
        Long semaforoId,

        @NotNull(message = "O ID da interseção é obrigatório!")
        Long intersecaoId,

        @NotBlank(message = "O status do semáforo é obrigatório!")
        String status,

        @Min(value = 0, message = "O tempo verde deve ser maior ou igual a 0")
        int tempoVerde,

        @Min(value = 0, message = "O tempo vermelho deve ser maior ou igual a 0")
        int tempoVermelho
) {
}
