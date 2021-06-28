package com.testedev.votacao.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Tentativa de voto duplicado para o associado informado!")
public class VotoDuplicadoException extends RuntimeException {

}
