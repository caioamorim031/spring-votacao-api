package com.testedev.votacao.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.testedev.votacao.api.entities.VotacaoEntity;
import com.testedev.votacao.api.ids.VotacaoKey;

public interface IVotacaoRepository extends CrudRepository<VotacaoEntity, VotacaoKey> {

}
