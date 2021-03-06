package com.testedev.votacao.api.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "pauta")
public class PautaEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pauta_id")
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fim")
	private Date dataFim;
	
	@OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VotacaoEntity> votos;
	
	public PautaEntity() {
	}

	public PautaEntity(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
