package br.com.compasso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.error.ResourceNotFoundException;
import br.com.compasso.model.Cidade;
import br.com.compasso.model.Cliente;
import br.com.compasso.repository.CidadeRepositorio;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	public Cidade salvar(Cidade cidade) {
		return cidadeRepositorio.save(cidade);	
	}
	
	public Cidade getCidadeByName(String nome) {
		Cidade cidade = cidadeRepositorio.findByNome(nome);
		if (cidade == null) {
			throw new ResourceNotFoundException("A "+ nome +" não existe");
		}
		return cidade;
	}
	
	public Cidade getCidadeByEstado(String nome) {
		return cidadeRepositorio.buscarCidadeByEstado(nome);	
	}
		
	public Cidade verificaCidade(Cliente cliente) {
		Cidade cidade = cidadeRepositorio.findByNome(cliente.getCidade().getNome());
		if (cidade == null) {
			throw new ResourceNotFoundException("Cidade não cadastrada: " + cliente.getCidade().getNome());
		}
		return cidade;
	}
}
