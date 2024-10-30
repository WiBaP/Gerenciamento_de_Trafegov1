package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AcidenteRepository extends JpaRepository<Acidente, Long> {

    @Query("SELECT a FROM tbl_acidentes a WHERE a.descricao = :descricao")
    Optional<Acidente> buscarPorDescricao(@Param("descricao") String descricao);

}
