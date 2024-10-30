package br.com.fiap.trafego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AcidenteNaoEncontradoException extends RuntimeException {

    public AcidenteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
