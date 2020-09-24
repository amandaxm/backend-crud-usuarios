package br.com.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.usuario.dominio.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
