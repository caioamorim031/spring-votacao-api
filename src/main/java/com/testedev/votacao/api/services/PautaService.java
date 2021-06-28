package com.testedev.votacao.api.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testedev.votacao.api.entities.PautaEntity;
import com.testedev.votacao.api.exceptions.PautaNaoEncontradaException;
import com.testedev.votacao.api.repositories.IPautaRepository;

@Service
public class PautaService {
	
	@Autowired
	private IPautaRepository repository;
	
	public boolean novaPauta(String pNome) {
		
		repository.save(new PautaEntity(pNome));
		
		return true;
	}
	
	public boolean novaPauta(String pNome, Date pData) {
		return false;
	}
	
public List<PautaEntity> consultarPauta(String pNome) {
		
		List<PautaEntity> lista = repository.findAllByNome(pNome);
		
		if(lista.isEmpty())
			throw new PautaNaoEncontradaException();
		
		return lista;
	}

}
