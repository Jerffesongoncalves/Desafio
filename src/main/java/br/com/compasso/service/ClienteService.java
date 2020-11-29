package br.com.compasso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.compasso.error.ResourceNotFoundException;
import br.com.compasso.model.Cidade;
import br.com.compasso.model.Cliente;
import br.com.compasso.repository.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private CidadeService cidadeService;
	
	public Cliente salvar(Cliente cliente) {
		Cidade cidade = cidadeService.verificaCidade(cliente);
		cidade.setNome(cliente.getCidade().getNome());
		cliente.setCidade(cidade);	
		return clienteRepositorio.save(cliente);	
	}
	
	public Cliente alterar(Integer id, Cliente cliente) {
		Cliente clienteBanco = getClienteById(id);
		clienteBanco.setNome(cliente.getNome());
		clienteBanco.setSobreNome(cliente.getSobreNome());
		clienteBanco.setSexo(cliente.getSexo());
		clienteBanco.setIdade(cliente.getIdade());
		clienteBanco.setCidade(cliente.getCidade());
		clienteBanco.setDataNascimento(cliente.getDataNascimento());
		
		Cidade cidade = cidadeService.verificaCidade(cliente);
		cliente.setCidade(cidade);
		clienteBanco.setCidade(cliente.getCidade());
		return clienteRepositorio.save(clienteBanco);
	}
	
	public Cliente getClienteById(Integer id) {
		return clienteRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado" ));
	}
	
	public Cliente getClienteByName(String nome) {
		Cliente cliente = clienteRepositorio.findByNome(nome);
		if (cliente == null) {
			throw new ResourceNotFoundException("Cliente não encontrado");
		}
		return cliente;
	}
	
	public void excluir(Integer id){
		Cliente cliente = clienteRepositorio.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado" ));
		clienteRepositorio.deleteById(cliente.getIdCliente());
	}	
}
