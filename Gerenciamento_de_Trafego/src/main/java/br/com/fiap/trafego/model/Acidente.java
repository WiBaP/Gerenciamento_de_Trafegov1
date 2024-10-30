package br.com.fiap.trafego.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate; // Importa LocalDate
@Entity(name = "tbl_acidentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Acidente {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ACIDENTES"
    )
    @SequenceGenerator(
            name = "SEQ_ACIDENTES",
            sequenceName = "SEQ_ACIDENTES",
            allocationSize = 1
    )
    @Column(name = "ACIDENTE_ID")
    private Long acidenteId;

    @ManyToOne
    @JoinColumn(name = "INTERSECAO_ID")
    @JsonIgnoreProperties("acidentes") // Evita a serialização/desserialização recursiva
    private Intersecao intersecao;

    @Column(name = "data_hora")
    private LocalDate dataHora;
    private String descricao;
    private String gravidade;
}
