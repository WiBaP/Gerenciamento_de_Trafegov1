package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Semaforo;

public record SemaforoExibicaoDTO(
        Long semaforoId,
        Long intersecaoId,
        String status,
        int tempoVerde,
        int tempoVermelho
) {

    public SemaforoExibicaoDTO(Semaforo semaforo) {
        this(
                semaforo.getSemaforoId(),
                semaforo.getIntersecao().getIntersecaoId(),
                semaforo.getStatus(),
                semaforo.getTempoVerde(),
                semaforo.getTempoVermelho()
        );
    }

}
