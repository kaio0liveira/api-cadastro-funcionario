package com.api.cadastro.funcionario.enums;

public enum Mensagens {

	NENHUM_RESULTADO_ENCONTRADO("Nenhum resultado encontrado.");
	
	
	private String mensagem;

	private Mensagens(String mensagem)
    {
        this.setMensagem(mensagem);
    }

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	} 
}




