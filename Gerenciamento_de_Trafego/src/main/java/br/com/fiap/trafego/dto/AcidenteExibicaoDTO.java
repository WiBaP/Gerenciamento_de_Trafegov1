package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Acidente;

import java.time.LocalDate;

public record AcidenteExibicaoDTO(
        Long acidenteId,
        Long intersecaoId,
        LocalDate dataHora,
        String descricao,
        String gravidade
) {

    public AcidenteExibicaoDTO(Acidente acidente) {
        this(
                acidente.getAcidenteId(),
                acidente.getIntersecao().getIntersecaoId(),
                acidente.getDataHora(),
                acidente.getDescricao(),
                acidente.getGravidade()
        );
    }

}
