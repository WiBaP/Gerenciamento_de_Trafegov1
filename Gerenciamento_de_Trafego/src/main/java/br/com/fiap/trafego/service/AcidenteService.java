package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.AcidenteCadastroDTO;
import br.com.fiap.trafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.trafego.exception.AcidenteNaoEncontradoException;
import br.com.fiap.trafego.model.Acidente;
import br.com.fiap.trafego.repository.AcidenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

    public Acidente salvarAcidente(AcidenteCadastroDTO acidenteDTO) {
        Acidente acidente = new Acidente();
        BeanUtils.copyProperties(acidenteDTO, acidente);
        return acidenteRepository.save(acidente);
    }

    public Acidente buscarPorId(Long id) {
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(id);
        return acidenteOptional.orElseThrow(() -> new AcidenteNaoEncontradoException("Acidente não existe no banco de dados!"));
    }

    public List<Acidente> listarTodos() {
        return acidenteRepository.findAll();
    }

    public void excluir(Long id) {
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(id);
        if (acidenteOptional.isPresent()) {
            acidenteRepository.delete(acidenteOptional.get());
        } else {
            throw new RuntimeException("Acidente não encontrado!");
        }
    }

    public Acidente atualizar(Acidente acidente) {
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(acidente.getAcidenteId());
        if (acidenteOptional.isPresent()) {
            return acidenteRepository.save(acidente);
        } else {
            throw new RuntimeException("Acidente não encontrado!");
        }
    }

    public AcidenteExibicaoDTO buscarPorDescricao(String descricao) {
        Optional<Acidente> acidenteOptional = acidenteRepository.buscarPorDescricao(descricao);

        if (acidenteOptional.isPresent()) {
            return new AcidenteExibicaoDTO(acidenteOptional.get());
        } else {
            throw new RuntimeException("Acidente não existe!");
        }
    }
}
