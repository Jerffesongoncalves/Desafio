package br.com.compasso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.controller.response.CidadeResponseDto;
import br.com.compasso.model.Cidade;
import br.com.compasso.service.CidadeService;

@RestController
@Validated
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeResponseDto salvar(@RequestBody @Valid Cidade cidade) {
		Cidade cidadeSalva = cidadeService.salvar(cidade);
		return new CidadeResponseDto(cidadeSalva);
	}
	
	@GetMapping(path = "/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeResponseDto getCidadeByName(@PathVariable("nome") String nome) {
		Cidade cidade = cidadeService.getCidadeByName(nome); 
		return new CidadeResponseDto(cidade);
	}
	
	@GetMapping(path = "/estado/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeResponseDto getCidadeByNameEstado(@PathVariable("nome") String nome) {
		Cidade cidade = cidadeService.getCidadeByEstado(nome);
		return new CidadeResponseDto(cidade);
	}
}
