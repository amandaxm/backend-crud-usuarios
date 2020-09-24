package br.com.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.dominio.Endereco;
import br.com.usuario.service.EnderecoService;
@RestController//converter res em json 
@RequestMapping("/endereco")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping(value = "/{id}") 
	public Endereco getEndereco(@PathVariable("id") Long id) {

		Endereco endereco = service.buscarEndereco(id);
		return endereco;
	}
	
	@GetMapping(value="/listar")
	public List<Endereco> listarEndereco(){
		return service.listarEndereco();
	} 
	
	@DeleteMapping(value="/{id}")
	public String excluirEndereco(@PathVariable("id") Long id) {
	 return service.excluirEndereco(id);
	}
	
	@PostMapping(value="/salvar")
	public void cadastrarEndereco(@RequestBody Endereco endereco) {
		service.cadastrarEndereco(endereco);
	}
	
	@PutMapping(value="/atualizar")
	public void atualizarEndereco(@RequestBody Endereco endereco) {
		service.atualizarEndereco(endereco);
	}
}
