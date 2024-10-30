package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "tbl_intersecoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Intersecao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_INTERSECOES"
    )
    @SequenceGenerator(
            name = "SEQ_INTERSECOES",
            sequenceName = "SEQ_INTERSECOES",
            allocationSize = 1
    )
    @Column(name = "INTERSECAO_ID")
    private Long intersecaoId;

    private String nome;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
