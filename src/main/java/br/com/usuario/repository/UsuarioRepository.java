package br.com.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usuario.dominio.Usuario;
//comecamos pelo repository
//JAVA RECONHECER QUE A CLASSE CONVERSA COM BANCO DE DADOS
// extends, nossa classe de entidade, long tipo do ID da classe chave 
//jpa metodos prontos que nao precisamos implementar
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
}
