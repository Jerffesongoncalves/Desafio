package br.com.compasso.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.controller.response.ClienteResponseDto;
import br.com.compasso.model.Cliente;
import br.com.compasso.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDto salvar(@RequestBody @Valid Cliente cliente) {
		Cliente clienteSalvo = clienteService.salvar(cliente);
		// Não devemos expor entidades na resposta.
		return new ClienteResponseDto(clienteSalvo);	
	}
	
	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto alterar(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente clienteAlterado =  clienteService.alterar(id, cliente);
		return new ClienteResponseDto(clienteAlterado);
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto getClienteById(@PathVariable("id") Integer id) {
		Cliente clienteId = clienteService.getClienteById(id);
		return new ClienteResponseDto(clienteId);
	}
	
	@GetMapping(path = "/clienteByName/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto getClienteByName(@PathVariable("nome") String nome) {
		Cliente cliente = clienteService.getClienteByName(nome);
		return new ClienteResponseDto(cliente);
	}
	
	@DeleteMapping({"/{id}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
	}
}
