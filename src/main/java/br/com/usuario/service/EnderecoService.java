package br.com.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuario.dominio.Endereco;
import br.com.usuario.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;

	public Endereco buscarEndereco(Long id) {
		Optional<Endereco> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	public List<Endereco> listarEndereco() {
		return repository.findAll();
	}

	public String excluirEndereco(Long id) {
		Endereco e = repository.findById(id).orElse(null);// se existe retorna id se nao retorna null
		if (e != null) {
			repository.deleteById(id);
			return "Endereço excluído com sucesso";
		} else {
			return "Endereço não existe";
		}
	}

	public void cadastrarEndereco(Endereco endereco) {
		repository.save(endereco);
		
	}

	public void atualizarEndereco(Endereco endereco) {
		repository.saveAndFlush(endereco);
	}
}
