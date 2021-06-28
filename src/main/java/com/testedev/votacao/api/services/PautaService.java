package com.testedev.votacao.api.services;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testedev.votacao.api.entities.PautaEntity;
import com.testedev.votacao.api.exceptions.AlteracaoNaoPermitidaException;
import com.testedev.votacao.api.exceptions.PautaNaoEncontradaException;
import com.testedev.votacao.api.exceptions.ValorParametroInvalidoException;
import com.testedev.votacao.api.repositories.IPautaRepository;
import com.testedev.votacao.api.utils.BibliotecaUtil;

@Service
public class PautaService {
	
	@Autowired
	private IPautaRepository repository;
	
	public boolean novaPauta(String pNome) {
		
		if(!BibliotecaUtil.isEntradaValida(pNome, true))
			throw new ValorParametroInvalidoException();
		
		repository.save(new PautaEntity(pNome));
		
		return true;
	}
	
	
	public List<PautaEntity> consultarPauta(String pNome) {
		
		if(!BibliotecaUtil.isEntradaValida(pNome, true))
			throw new ValorParametroInvalidoException();
		
		List<PautaEntity> lista = repository.findAllByNome(pNome);
		
		if(lista.isEmpty())
			throw new PautaNaoEncontradaException();
		
		return lista;
	}
	
	public PautaEntity consultarPauta(Long pId) {
		
		if(!BibliotecaUtil.isValorValido(pId))
			throw new ValorParametroInvalidoException();
		
		PautaEntity pauta = repository.findById(pId).orElseThrow(() -> new PautaNaoEncontradaException());
		
		
		return pauta;
	}

	@Transactional
	public void aberturaSessao(Long pId, Long pTempo) {
		
		if(BibliotecaUtil.isValorValido(pId) && BibliotecaUtil.isValorValido(pTempo)) {
			PautaEntity pauta = repository.findById(pId).orElseThrow(() -> new PautaNaoEncontradaException());
			
			if(pauta.getDataFim() != null) {
				throw new AlteracaoNaoPermitidaException();
			}
			
			repository.updateFimDataById(BibliotecaUtil.addMinutosInSysdate(pTempo), pId);
			
		} else {
			throw new ValorParametroInvalidoException();
		}
		
	}
	
}
