package br.com.compasso.controller.response;

import br.com.compasso.model.Cidade;

public class CidadeResponseDto {

	private Cidade cidade;

	public CidadeResponseDto() {
	}
	
	public CidadeResponseDto(Cidade cidade) {
		super();
		this.cidade = cidade;
	}
	public String getNome() {
		return cidade.getNome();
	}
	public String getEstado() {
		return cidade.getEstado();
	}
}
