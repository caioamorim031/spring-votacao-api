package com.testedev.votacao.api.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "associado")
public class AssociadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "associado_id")
	private Long Id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VotacaoEntity> votos;
	
	public AssociadoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public AssociadoEntity(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
