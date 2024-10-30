package br.com.fiap.trafego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IntersecaoNaoEncontradaException extends RuntimeException {

    public IntersecaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
