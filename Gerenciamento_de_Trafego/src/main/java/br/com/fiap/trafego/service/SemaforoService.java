package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.SemaforoCadastroDTO;
import br.com.fiap.trafego.dto.SemaforoExibicaoDTO;
import br.com.fiap.trafego.exception.SemaforoNaoEncontradoException;
import br.com.fiap.trafego.model.Semaforo;
import br.com.fiap.trafego.repository.SemaforoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public Semaforo salvarSemaforo(SemaforoCadastroDTO semaforoDTO){
        Semaforo semaforo = new Semaforo();
        BeanUtils.copyProperties(semaforoDTO, semaforo);
        return semaforoRepository.save(semaforo);
    }

    public Semaforo buscarPorId(Long id){
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(id);
        return semaforoOptional.orElseThrow(() -> new SemaforoNaoEncontradoException("Semáforo não existe no banco de dados!"));
    }

    public List<Semaforo> listarTodos(){
        return semaforoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(id);
        if (semaforoOptional.isPresent()){
            semaforoRepository.delete(semaforoOptional.get());
        } else {
            throw new RuntimeException("Semáforo não encontrado!");
        }
    }

    public Semaforo atualizar(Semaforo semaforo){
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(semaforo.getSemaforoId());
        if (semaforoOptional.isPresent()){
            return semaforoRepository.save(semaforo);
        } else {
            throw new RuntimeException("Semáforo não encontrado!");
        }
    }
    public SemaforoExibicaoDTO buscarPorStatus(String status) {
        Optional<Semaforo> semaforoOptional = semaforoRepository.buscarPorStatus(status);

        if (semaforoOptional.isPresent()) {
            return new SemaforoExibicaoDTO(semaforoOptional.get());
        } else {
            throw new RuntimeException("Semáforo não existe!");
        }
    }
}
