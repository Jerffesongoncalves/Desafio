package br.com.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.model.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

	public Cidade findByNome(String nome);
	
	@Query("select c from Cidade c where c.estado = ?1")
	public Cidade buscarCidadeByEstado(String nome);
}
