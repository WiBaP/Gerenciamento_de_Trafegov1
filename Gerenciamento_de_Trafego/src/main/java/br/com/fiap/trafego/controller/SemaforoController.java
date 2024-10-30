package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.SemaforoCadastroDTO;
import br.com.fiap.trafego.dto.SemaforoExibicaoDTO;
import br.com.fiap.trafego.model.Semaforo;
import br.com.fiap.trafego.service.SemaforoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemaforoController {

    @Autowired
    private SemaforoService semaforoService;

    @PostMapping("/semaforos")
    @ResponseStatus(HttpStatus.CREATED)
    public Semaforo salvar(@RequestBody @Valid SemaforoCadastroDTO semaforo){
        return semaforoService.salvarSemaforo(semaforo);
    }

    @GetMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public List<Semaforo> listarTodos(){
        return semaforoService.listarTodos();
    }

    @GetMapping("/semaforos/{semaforoId}")
    public ResponseEntity<Semaforo> buscarPorId(@PathVariable Long semaforoId){
        return ResponseEntity.ok(semaforoService.buscarPorId(semaforoId));
    }

    @DeleteMapping("/semaforos/{semaforoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long semaforoId){
        semaforoService.excluir(semaforoId);
    }

    @PutMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public Semaforo atualizar(@RequestBody Semaforo semaforo){
        return semaforoService.atualizar(semaforo);
    }
    @GetMapping("/buscarPorStatus")
    public SemaforoExibicaoDTO buscarPorStatus(@RequestParam String status) {
        return semaforoService.buscarPorStatus(status);
    }
}
