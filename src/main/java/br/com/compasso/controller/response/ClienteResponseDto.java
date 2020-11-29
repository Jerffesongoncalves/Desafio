package br.com.compasso.controller.response;


import java.util.Date;

import br.com.compasso.model.Cliente;

public class ClienteResponseDto {

	private Cliente cliente;

	public ClienteResponseDto(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	public Integer getIdCliente() {
		return cliente.getIdCliente();
	}
	public String getNome() {
		return cliente.getNome() +" "+ cliente.getSobreNome();
	}
	public String getSexo() {
		return cliente.getSexo();
	}
	public Date getDataNascimento() {
		return cliente.getDataNascimento();
	}
	public Long getIdade() {
		return cliente.getIdade();
	}
	public String getCidade() {
		return cliente.getCidade().getNome();
	}
}
