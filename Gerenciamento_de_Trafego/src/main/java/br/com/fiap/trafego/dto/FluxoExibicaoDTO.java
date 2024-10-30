package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Fluxo;

import java.time.LocalDate;

public record FluxoExibicaoDTO(
        Long fluxoId,
        Long intersecaoId,
        LocalDate dataHora,
        Integer quantidadeVeiculos
) {

    public FluxoExibicaoDTO(Fluxo fluxo) {
        this(
                fluxo.getFluxoId(),
                fluxo.getIntersecao().getIntersecaoId(),
                fluxo.getDataHora(),
                fluxo.getQuantidadeVeiculos()
        );
    }

}


