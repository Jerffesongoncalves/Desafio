package br.com.compasso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Integer idCliente;
	
	@Column(length = 250, nullable = false)
	@NotBlank(message = "{cliente.nome.obrigatorio}")
	private String nome;
	
	@Column(length = 250, nullable = false)
	@NotBlank(message = "{cliente.sobreNome.obrigatorio}")
	private String sobreNome;
	
	@Column(length = 50, nullable = false)
	@NotBlank(message = "{cliente.sexo.obrigatorio}")
	private String sexo;
	
	@Column(nullable = false)
	@NotNull(message = "{cliente.dataNascimento.obrigatorio}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(nullable = false)
	@NotNull(message = "{cliente.idade.obrigatorio}")
	private Long idade;
	
	@OneToOne
	@NotNull(message = "{cliente.cidade.obrigatorio} ") 
	@JoinColumn(name = "cidade")
	private Cidade cidade;
	 
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getIdade() {
		return idade;
	}
	public void setIdade(Long idade) {
		this.idade = idade;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}	
}
