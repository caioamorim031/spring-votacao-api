package com.testedev.votacao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testedev.votacao.api.services.AssociadoService;

@RestController
@RequestMapping("api/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;
	
	@PostMapping("v1/cadastrar")
	public ResponseEntity<String> adicionarAssociado(@RequestParam(value = "nome") String pNome){
		
		service.novoAssociado(pNome);
		
		return ResponseEntity.ok("Novo Associado gerado com sucesso!");
	}

}
