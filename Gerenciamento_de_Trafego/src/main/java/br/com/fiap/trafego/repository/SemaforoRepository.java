package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {

    @Query("SELECT s FROM tbl_semaforos s WHERE s.status = :status")
    Optional<Semaforo> buscarPorStatus(@Param("status") String status);

}
