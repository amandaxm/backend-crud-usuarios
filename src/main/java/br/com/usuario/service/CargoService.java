package br.com.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuario.dominio.Cargo;
import br.com.usuario.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	public Cargo buscarCargo(Long id) {
		Optional<Cargo> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	public List<Cargo> listarCargo() {
		return repository.findAll();
	}

	public String excluirCargo(Long id) {
		Cargo e = repository.findById(id).orElse(null);
		if (e != null) {
			repository.deleteById(id);
			return "Cargo excluído com sucesso";
		} else {
			return "Cargo não existe";
		}
	}

	public void cadastrarCargo(Cargo cargo) {
		repository.save(cargo);
	}

	public void atualizarCargo(Cargo cargo) {
		repository.saveAndFlush(cargo);
	}
}
