package br.com.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.usuario.dominio.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
