package br.com.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.compasso.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
		public Cliente findByNome(String nome);
	
}
