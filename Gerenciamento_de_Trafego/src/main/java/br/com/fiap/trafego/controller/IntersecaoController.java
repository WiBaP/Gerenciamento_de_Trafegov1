package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.IntersecaoCadastroDTO;
import br.com.fiap.trafego.dto.IntersecaoExibicaoDTO;
import br.com.fiap.trafego.model.Intersecao;
import br.com.fiap.trafego.service.IntersecaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IntersecaoController {

    @Autowired
    private IntersecaoService intersecaoService;

    @PostMapping("/intersecoes")
    @ResponseStatus(HttpStatus.CREATED)
    public Intersecao salvar(@RequestBody @Valid IntersecaoCadastroDTO intersecao){
        return intersecaoService.salvarIntersecao(intersecao);
    }

    @GetMapping("/intersecoes")
    @ResponseStatus(HttpStatus.OK)
    public List<Intersecao> listarTodas(){
        return intersecaoService.listarTodas();
    }

    @GetMapping("/intersecoes/{intersecaoId}")
    public ResponseEntity<Intersecao> buscarPorId(@PathVariable Long intersecaoId){
        return ResponseEntity.ok(intersecaoService.buscarPorId(intersecaoId));
    }

    @DeleteMapping("/intersecoes/{intersecaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long intersecaoId){
        intersecaoService.excluir(intersecaoId);
    }

    @PutMapping("/intersecoes")
    @ResponseStatus(HttpStatus.OK)
    public Intersecao atualizar(@RequestBody Intersecao intersecao){
        return intersecaoService.atualizar(intersecao);
    }
    @GetMapping("/intersecoes/nome/{nome}")
    public IntersecaoExibicaoDTO buscarPorNome(@RequestParam String nome) {
        return intersecaoService.buscarPorNome(nome);
    }

}
