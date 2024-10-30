package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Intersecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IntersecaoRepository extends JpaRepository<Intersecao, Long> {

    @Query("SELECT i FROM tbl_intersecoes i WHERE i.nome = :nome")
    Optional<Intersecao> buscarPorNome(@Param("nome") String nome);

}
