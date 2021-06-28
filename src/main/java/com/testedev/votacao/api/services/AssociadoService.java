package com.testedev.votacao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testedev.votacao.api.entities.AssociadoEntity;
import com.testedev.votacao.api.exceptions.AssociadoNaoEncontradoException;
import com.testedev.votacao.api.exceptions.ValorParametroInvalidoException;
import com.testedev.votacao.api.repositories.IAssociadoRepository;
import com.testedev.votacao.api.utils.BibliotecaUtil;

@Service
public class AssociadoService {
	
	@Autowired
	private IAssociadoRepository repository;
	
	public void novoAssociado(String pNome) {
		
		if(!BibliotecaUtil.isEntradaValida(pNome, false))
			throw new ValorParametroInvalidoException();
		
		repository.save(new AssociadoEntity(pNome));
	}
	
	public boolean isAssociadoValido(Long pId) {
		
		if(!BibliotecaUtil.isValorValido(pId))
			throw new ValorParametroInvalidoException();
		
		repository.findById(pId).orElseThrow(() -> new AssociadoNaoEncontradoException());
		
		
		return true;
	}
	
public AssociadoEntity consultarAssociado(Long pId) {
		
		if(!BibliotecaUtil.isValorValido(pId))
			throw new ValorParametroInvalidoException();
		
		return repository.findById(pId).orElseThrow(() -> new AssociadoNaoEncontradoException());
	}

}
