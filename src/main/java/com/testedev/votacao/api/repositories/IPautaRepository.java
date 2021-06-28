package com.testedev.votacao.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.testedev.votacao.api.entities.PautaEntity;

public interface IPautaRepository extends CrudRepository<PautaEntity, Long>{
	
	public List<PautaEntity> findAllByNome(String pNome);
	

}
