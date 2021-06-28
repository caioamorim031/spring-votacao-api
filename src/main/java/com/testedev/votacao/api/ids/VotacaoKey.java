package com.testedev.votacao.api.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VotacaoKey implements Serializable {
	
	@Column(name = "pauta_id")
	private Long pautaId;
	
	@Column(name = "associado_id")
	private Long associadoId;

	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public Long getAssociadoId() {
		return associadoId;
	}

	public void setAssociadoId(Long associadoId) {
		this.associadoId = associadoId;
	}

}
