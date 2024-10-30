package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.FluxoCadastroDTO;
import br.com.fiap.trafego.dto.FluxoExibicaoDTO;
import br.com.fiap.trafego.model.Fluxo;
import br.com.fiap.trafego.service.FluxoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FluxoController {

    @Autowired
    private FluxoService fluxoService;

    @PostMapping("/fluxos")
    @ResponseStatus(HttpStatus.CREATED)
    public Fluxo salvar(@RequestBody @Valid FluxoCadastroDTO fluxo){
        return fluxoService.salvarFluxo(fluxo);
    }

    @GetMapping("/fluxos")
    @ResponseStatus(HttpStatus.OK)
    public List<Fluxo> listarTodos(){
        return fluxoService.listarTodos();
    }

    @GetMapping("/fluxos/{fluxoId}")
    public ResponseEntity<Fluxo> buscarPorId(@PathVariable Long fluxoId){
        return ResponseEntity.ok(fluxoService.buscarPorId(fluxoId));
    }

    @DeleteMapping("/fluxos/{fluxoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long fluxoId){
        fluxoService.excluir(fluxoId);
    }

    @PutMapping("/fluxos")
    @ResponseStatus(HttpStatus.OK)
    public Fluxo atualizar(@RequestBody Fluxo fluxo){
        return fluxoService.atualizar(fluxo);
    }

    @GetMapping("/buscarPorDataHora")
    public FluxoExibicaoDTO buscarPorDataHora(@RequestParam LocalDate dataHora) {
        return fluxoService.buscarPorDataHora(dataHora);
    }

}
