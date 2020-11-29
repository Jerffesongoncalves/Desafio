package br.com.compasso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCidade;
	
	@Column(length = 250, nullable = false)
	@NotBlank(message = "{cidade.nome.obrigatorio}")
	private String nome;
	
	@Column(length = 250, nullable = false)
	@NotBlank(message = "{cidade.estado.obrigatorio}")
	private String estado;
	
	
	public Integer getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
