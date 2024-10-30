package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Intersecao;

import java.math.BigDecimal;

public record IntersecaoExibicaoDTO(
        Long intersecaoId,
        String nome,
        BigDecimal latitude,
        BigDecimal longitude
) {

    public IntersecaoExibicaoDTO(Intersecao intersecao) {
        this(
                intersecao.getIntersecaoId(),
                intersecao.getNome(),
                intersecao.getLatitude(),
                intersecao.getLongitude()
        );
    }

}
