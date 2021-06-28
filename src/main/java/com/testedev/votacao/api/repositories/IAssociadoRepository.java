package com.testedev.votacao.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.testedev.votacao.api.entities.AssociadoEntity;

public interface IAssociadoRepository extends CrudRepository<AssociadoEntity, Long> {

}
