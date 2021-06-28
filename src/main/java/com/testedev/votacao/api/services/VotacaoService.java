package com.testedev.votacao.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testedev.votacao.api.entities.PautaEntity;
import com.testedev.votacao.api.entities.VotacaoEntity;
import com.testedev.votacao.api.exceptions.SessaoFechadaException;
import com.testedev.votacao.api.exceptions.SessaoNaoAbertaException;
import com.testedev.votacao.api.exceptions.ValorParametroInvalidoException;
import com.testedev.votacao.api.exceptions.VotoDuplicadoException;
import com.testedev.votacao.api.ids.VotacaoKey;
import com.testedev.votacao.api.repositories.IVotacaoRepository;
import com.testedev.votacao.api.utils.BibliotecaUtil;

@Service
public class VotacaoService {
	
	@Autowired
	private PautaService servicoPauta;
	
	@Autowired
	private AssociadoService servicoAssociado;
	
	@Autowired
	private IVotacaoRepository repository;
	
	public boolean isVotacaoAberta(Long pCodigoPauta) {
		
		if(BibliotecaUtil.isValorValido(pCodigoPauta)) {
			PautaEntity pauta = servicoPauta.consultarPauta(pCodigoPauta);
			
			if(pauta.getDataFim() != null) {
				Date dataAtual = new Date();
				if(dataAtual.before(pauta.getDataFim())) {
					return true;
				} else {
					throw new SessaoFechadaException();
				}
			} else {
				throw new SessaoNaoAbertaException();
			}
		} else {
			throw new ValorParametroInvalidoException();
		}
	}
	
	public void efetivarVotacao(Long pCdPauta, Long pCdAssociado, String pVoto) {
		
		if(this.isVotacaoAberta(pCdPauta) 
				&& servicoAssociado.isAssociadoValido(pCdAssociado) 
				&& isVotoValido(pVoto)) {
			VotacaoKey id = new  VotacaoKey();
			id.setPautaId(pCdPauta);
			id.setAssociadoId(pCdAssociado);
			
			VotacaoEntity votacao = repository.findById(id).orElse(null);
			
			if(votacao != null) {
				throw new VotoDuplicadoException();
			} else {
				votacao = new VotacaoEntity();
				votacao.setId(id);
				votacao.setVoto(pVoto);
				votacao.setPauta(servicoPauta.consultarPauta(pCdPauta));
				votacao.setAssociado(servicoAssociado.consultarAssociado(pCdAssociado));
				repository.save(votacao);
			}
			
		}
		
	}
	
	public boolean isVotoValido(String pVoto) {
		if(pVoto.equalsIgnoreCase("Sim") || pVoto.equalsIgnoreCase("Não")) {
			return true;
		}
		return false;
	}
	
	
}
