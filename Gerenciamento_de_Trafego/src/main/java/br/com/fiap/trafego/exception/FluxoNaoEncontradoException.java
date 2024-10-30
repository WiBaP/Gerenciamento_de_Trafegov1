package br.com.fiap.trafego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FluxoNaoEncontradoException extends RuntimeException {

    public FluxoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
