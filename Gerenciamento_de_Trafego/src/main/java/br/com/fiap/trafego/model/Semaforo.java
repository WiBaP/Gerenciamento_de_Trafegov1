package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tbl_semaforos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Semaforo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SEMAFOROS"
    )
    @SequenceGenerator(
            name = "SEQ_SEMAFOROS",
            sequenceName = "SEQ_SEMAFOROS",
            allocationSize = 1
    )
    @Column(name = "SEMAFORO_ID")
    private Long semaforoId;

    @ManyToOne
    @JoinColumn(name = "INTERSECAO_ID")
    private Intersecao intersecao;

    private String status;
    private int tempoVerde;
    private int tempoVermelho;
}
