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

import br.com.usuario.dominio.Usuario;
import br.com.usuario.service.UsuarioService;

@RestController//converter res em json 
@RequestMapping("/usuario")
public class UsuarioController {
//controller conversa com service atraves do autowired
	@Autowired
	private UsuarioService service;


	//vai para @PathVariable("id") long id, @PathVariable("id") mapeia a variavel
	@GetMapping(value = "/{id}") // id que vier da url e jogar no buscarUsuario
	public Usuario getUsuario(@PathVariable("id") Long id) {

		Usuario usuario = service.buscarUsuario(id);//usuario que retrnar colocamos dentro desse usuario
		//System.out.println(usuario.getNome());
		return usuario;
	}
	
	
	
	@GetMapping(value="/listar")
	public List<Usuario> listarUsuarios(){
		return service.listarUsuarios();
	} 
	
	
	
	@DeleteMapping(value="/{id}")
	public String excluirUsuario(@PathVariable("id") Long id) {
	 return service.excluirUsuario(id);
	}
	
	
	@PostMapping(value="/salvar")//inserir no servidor 
	public void cadastrarUsuario(@RequestBody Usuario usuario) {//request body coverte para java
		service.cadastrarUsuario(usuario);
	}
	
	
	
	@PutMapping(value="/atualizar") 
	public void atualizarUsuario(@RequestBody Usuario usuario) {//request body coverte para java
		service.atualizarUsuario(usuario);
	}
}
