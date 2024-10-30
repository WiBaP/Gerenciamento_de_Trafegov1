package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.FluxoCadastroDTO;
import br.com.fiap.trafego.dto.FluxoExibicaoDTO;
import br.com.fiap.trafego.exception.FluxoNaoEncontradoException;
import br.com.fiap.trafego.model.Fluxo;
import br.com.fiap.trafego.repository.FluxoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FluxoService {

    @Autowired
    private FluxoRepository fluxoRepository;

    public Fluxo salvarFluxo(FluxoCadastroDTO fluxoDTO){
        Fluxo fluxo = new Fluxo();
        BeanUtils.copyProperties(fluxoDTO, fluxo);
        return fluxoRepository.save(fluxo);
    }

    public Fluxo buscarPorId(Long id){
        Optional<Fluxo> fluxoOptional = fluxoRepository.findById(id);
        return fluxoOptional.orElseThrow(() -> new FluxoNaoEncontradoException("Fluxo não existe no banco de dados!"));
    }

    public List<Fluxo> listarTodos(){
        return fluxoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Fluxo> fluxoOptional = fluxoRepository.findById(id);
        if (fluxoOptional.isPresent()){
            fluxoRepository.delete(fluxoOptional.get());
        } else {
            throw new RuntimeException("Fluxo não encontrado!");
        }
    }

    public Fluxo atualizar(Fluxo fluxo){
        Optional<Fluxo> fluxoOptional = fluxoRepository.findById(fluxo.getFluxoId());
        if (fluxoOptional.isPresent()){
            return fluxoRepository.save(fluxo);
        } else {
            throw new RuntimeException("Fluxo não encontrado!");
        }
    }

    public FluxoExibicaoDTO buscarPorDataHora(LocalDate dataHora) {
        Optional<Fluxo> fluxoOptional = fluxoRepository.buscarPorDataHora(dataHora);

        if (fluxoOptional.isPresent()) {
            return new FluxoExibicaoDTO(fluxoOptional.get());
        } else {
            throw new RuntimeException("Fluxo não existe!");
        }
    }
}
