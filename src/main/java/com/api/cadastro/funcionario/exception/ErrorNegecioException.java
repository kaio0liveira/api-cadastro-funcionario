package com.api.cadastro.funcionario.exception;

import com.api.cadastro.funcionario.enums.Mensagens;

public class ErrorNegecioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorNegecioException(Mensagens mensagem) {
		super(mensagem.getMensagem());
	}
	
}
