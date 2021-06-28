package com.testedev.votacao.api.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.testedev.votacao.api.ids.VotacaoKey;

@Entity
@Table(name = "votacao")
public class VotacaoEntity {
	
	@EmbeddedId
	private VotacaoKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pautaId")
	@JoinColumn(name = "pauta_id")
	private PautaEntity pauta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("associadoId")
	@JoinColumn(name = "associado_id")
	private AssociadoEntity associado;
	
	private String voto;

	public VotacaoKey getId() {
		return id;
	}

	public void setId(VotacaoKey id) {
		this.id = id;
	}

	public PautaEntity getPauta() {
		return pauta;
	}

	public void setPauta(PautaEntity pauta) {
		this.pauta = pauta;
	}

	public AssociadoEntity getAssociado() {
		return associado;
	}

	public void setAssociado(AssociadoEntity associado) {
		this.associado = associado;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

}
