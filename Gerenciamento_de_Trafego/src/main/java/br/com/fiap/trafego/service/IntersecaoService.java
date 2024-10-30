package br.com.fiap.trafego.service;

import br.com.fiap.trafego.dto.IntersecaoCadastroDTO;
import br.com.fiap.trafego.dto.IntersecaoExibicaoDTO;
import br.com.fiap.trafego.exception.IntersecaoNaoEncontradaException;
import br.com.fiap.trafego.model.Intersecao;
import br.com.fiap.trafego.repository.IntersecaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntersecaoService {

    @Autowired
    private IntersecaoRepository intersecaoRepository;

    public Intersecao salvarIntersecao(IntersecaoCadastroDTO intersecaoDTO) {
        Intersecao intersecao = new Intersecao();
        BeanUtils.copyProperties(intersecaoDTO, intersecao);
        return intersecaoRepository.save(intersecao);
    }

    public Intersecao buscarPorId(Long id) {
        Optional<Intersecao> intersecaoOptional = intersecaoRepository.findById(id);
        return intersecaoOptional.orElseThrow(() -> new IntersecaoNaoEncontradaException("Interseção não existe no banco de dados!"));
    }

    public List<Intersecao> listarTodas() {
        return intersecaoRepository.findAll();
    }

    public void excluir(Long id) {
        Optional<Intersecao> intersecaoOptional = intersecaoRepository.findById(id);
        if (intersecaoOptional.isPresent()) {
            intersecaoRepository.delete(intersecaoOptional.get());
        } else {
            throw new RuntimeException("Interseção não encontrada!");
        }
    }

    public Intersecao atualizar(Intersecao intersecao) {
        Optional<Intersecao> intersecaoOptional = intersecaoRepository.findById(intersecao.getIntersecaoId());
        if (intersecaoOptional.isPresent()) {
            return intersecaoRepository.save(intersecao);
        } else {
            throw new RuntimeException("Interseção não encontrada!");
        }
    }

    public IntersecaoExibicaoDTO buscarPorNome(String nome) {
        Optional<Intersecao> intersecaoOptional = intersecaoRepository.buscarPorNome(nome);

        if (intersecaoOptional.isPresent()) {
            return new IntersecaoExibicaoDTO(intersecaoOptional.get());
        } else {
            throw new RuntimeException("Interseção não existe!");
        }
    }
}
