package com.testedev.votacao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testedev.votacao.api.dtos.VotacaoDTO;
import com.testedev.votacao.api.services.AssociadoService;
import com.testedev.votacao.api.services.VotacaoService;

@RestController
@RequestMapping("api/votacao")
public class VotacaoController {

	@Autowired
	private VotacaoService serviceVotacao;
	
	@PostMapping("v1/votar")
	public ResponseEntity<String> votar(@RequestBody VotacaoDTO dto) {
		
		if(!validarDto(dto)) {
			return ResponseEntity.badRequest().body("Verifique as informações antes de enviar a solicitação de votação!");
		}
		
		
		serviceVotacao.efetivarVotacao(dto.getPautaId(), dto.getAssociadoId(), dto.getVoto());
		
		return ResponseEntity.ok("Voto contabilizado!");
		
		
	}
	
	public boolean validarDto(VotacaoDTO pDto) {
		if(pDto.getAssociadoId() != null 
				&& pDto.getPautaId() != null 
				&& pDto.getVoto() != null) {
			return true;
		}
		return false;
	}
}
