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

import br.com.usuario.dominio.Cargo;
import br.com.usuario.service.CargoService;

@RestController//converter res em json 
@RequestMapping("/cargo")
public class CargoController {
	@Autowired
	private CargoService service;
	
	@GetMapping(value = "/{id}") 
	public Cargo getCargo(@PathVariable("id") Long id) {

		Cargo cargo = service.buscarCargo(id);
		return cargo;
	}
	
	@GetMapping(value="/listar")
	public List<Cargo> listarCargo(){
		return service.listarCargo();
	} 
	
	@DeleteMapping(value="/{id}")
	public String excluirCargo(@PathVariable("id") Long id) {
	 return service.excluirCargo(id);
	}
	
	@PostMapping(value="/salvar")
	public void cadastrarCargo(@RequestBody Cargo cargo) {
		service.cadastrarCargo(cargo);
	}
	
	@PutMapping(value="/atualizar")
	public void atualizarCargo(@RequestBody Cargo carlo) {
		service.atualizarCargo(carlo);
	}
}
