package com.testedev.votacao.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Associado não encontrado")
public class AssociadoNaoEncontradoException extends RuntimeException {

}
