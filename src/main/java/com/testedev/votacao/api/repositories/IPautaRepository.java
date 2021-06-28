package com.testedev.votacao.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testedev.votacao.api.entities.PautaEntity;

public interface IPautaRepository extends CrudRepository<PautaEntity, Long>{
	
	public List<PautaEntity> findAllByNome(String pNome);
	
	@Modifying
	@Query(value = "update PautaEntity set data_fim = :data where id = :id")
	int updateFimDataById(@Param("data") String data, @Param("id") Long id);
	

}
