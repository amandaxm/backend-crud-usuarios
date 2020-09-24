package br.com.usuario.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity // configuração classe de entidade deve ter uma tabela no banco com esse nome
@Table(name = "USUARIO")
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(generator = "SQ_USUARIO")
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "idade")
	private Integer idade;

	@Column(name = "cpf")
	private String cpf;

	// @OneToMany(cascade = CascadeType.ALL)
	// private List<Endereco> enderecos;

	@OneToOne
	private Cargo cargo;

	@JsonManagedReference
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> enderecos = new ArrayList<>();

	// @OneToOne(cascade = CascadeType.ALL)//cascade, deletar usuario deleta
	// endereco, insere u insere e
	// @OneToMany(cascade = CascadeType.ALL, mappedyBy="endereco")
	// private List<Endereco> enderecoList;//1 -> 1 usuario tem um endereco

}
