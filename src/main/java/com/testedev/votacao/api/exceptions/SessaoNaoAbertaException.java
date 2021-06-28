package com.testedev.votacao.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Sessão ainda não foi aberta!")
public class SessaoNaoAbertaException extends RuntimeException{

}
