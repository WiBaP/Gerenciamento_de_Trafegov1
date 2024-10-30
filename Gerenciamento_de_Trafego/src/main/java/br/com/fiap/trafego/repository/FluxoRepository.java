package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Fluxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface FluxoRepository extends JpaRepository<Fluxo, Long> {

    @Query("SELECT f FROM tbl_fluxos f WHERE f.dataHora = :dataHora")
    Optional<Fluxo> buscarPorDataHora(@Param("dataHora") LocalDate dataHora);

}

