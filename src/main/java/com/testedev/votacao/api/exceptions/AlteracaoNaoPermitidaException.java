package com.testedev.votacao.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Não é permitido alteração de fim de data")
public class AlteracaoNaoPermitidaException extends RuntimeException {

}
