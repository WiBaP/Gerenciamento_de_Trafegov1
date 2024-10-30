package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate; // Importa LocalDate

@Entity(name = "tbl_fluxos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Fluxo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_FLUXOS"
    )
    @SequenceGenerator(
            name = "SEQ_FLUXOS",
            sequenceName = "SEQ_FLUXOS",
            allocationSize = 1
    )
    @Column(name = "FLUXO_ID")
    private Long fluxoId;

    @ManyToOne
    @JoinColumn(name = "INTERSECAO_ID")
    private Intersecao intersecao;
    @Column(name = "data_hora")
    private LocalDate dataHora;
    private int quantidadeVeiculos;
}
