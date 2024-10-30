package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.AcidenteCadastroDTO;
import br.com.fiap.trafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.trafego.model.Acidente;
import br.com.fiap.trafego.service.AcidenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AcidenteController {

    @Autowired
    private AcidenteService acidenteService;

    @PostMapping("/acidentes")
    @ResponseStatus(HttpStatus.CREATED)
    public Acidente salvar(@RequestBody @Valid AcidenteCadastroDTO acidente){
        return acidenteService.salvarAcidente(acidente);
    }

    @GetMapping("/acidentes")
    @ResponseStatus(HttpStatus.OK)
    public List<Acidente> listarTodos(){
        return acidenteService.listarTodos();
    }

    @GetMapping("/acidentes/{acidenteId}")
    public ResponseEntity<Acidente> buscarPorId(@PathVariable Long acidenteId){
        return ResponseEntity.ok(acidenteService.buscarPorId(acidenteId));
    }

    @DeleteMapping("/acidentes/{acidenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long acidenteId){
        acidenteService.excluir(acidenteId);
    }

    @PutMapping("/acidentes")
    @ResponseStatus(HttpStatus.OK)
    public Acidente atualizar(@RequestBody Acidente acidente){
        return acidenteService.atualizar(acidente);
    }

    @GetMapping("/buscarPorDescricao")
    public AcidenteExibicaoDTO buscarPorDescricao(@RequestParam String descricao) {
        return acidenteService.buscarPorDescricao(descricao);
    }

}
