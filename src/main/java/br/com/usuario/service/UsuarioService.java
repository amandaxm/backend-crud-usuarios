package br.com.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuario.dominio.Usuario;
import br.com.usuario.repository.UsuarioRepository;
//segundo vamos para o service
//regras de negócio
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;// objeto do tipo usuario repository
	
	
	public Usuario buscarUsuario(Long id){
		//<Tipo de objeto que está buscando>
		Optional<Usuario> op = repository.findById(id);//retorna opção usuario
		if(op.isPresent()) {
			return op.get();	
		}else {
			return null;
		}
	}
	
	public List<Usuario> listarUsuarios(){
		return repository.findAll();
		
	} 
	
	public String excluirUsuario(Long id) {
		Usuario u = repository.findById(id).orElse(null);//se existe retorna id se nao retorna null
		if(u!= null) {
			repository.deleteById(id);	
			return "Usuário excluído com sucesso";
		}else {
			return "Usuário não existe";  
		}
		
	}
	public void cadastrarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	public void atualizarUsuario(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}
}
