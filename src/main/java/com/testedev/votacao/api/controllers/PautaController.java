package com.testedev.votacao.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testedev.votacao.api.dtos.PautaDTO;
import com.testedev.votacao.api.entities.PautaEntity;
import com.testedev.votacao.api.exceptions.ValorParametroInvalidoException;
import com.testedev.votacao.api.response.Response;
import com.testedev.votacao.api.services.PautaService;
import com.testedev.votacao.api.utils.BibliotecaUtil;

@RestController
@RequestMapping("api/pauta")
public class PautaController {
	
	@Autowired
	private PautaService pautaService;
	
	@PostMapping(value = "v1/cadastrar")
	public ResponseEntity<String> cadastrarPauta(@RequestParam(value = "nome") String pNome) {
		
		if(pautaService.novaPauta(pNome)) {
			return ResponseEntity.ok("Pauta de nome '" + pNome + "' inserida com sucesso!");
		}
		return ResponseEntity.badRequest().body("Erro ao inserir nova pauta");
		
	}
	
	@GetMapping(value = "v1/consultar")
	public ResponseEntity<Response<PautaDTO>> consultarPauta(@RequestBody PautaDTO pauta){
		
		Response<PautaDTO> response = new Response<PautaDTO>();
		
		List<PautaDTO> listaDtos = new ArrayList();
		
		pautaService.consultarPauta(pauta.getNome()).forEach(pautaRetornada -> {
			listaDtos.add(converterParaDTO(pautaRetornada));
		});
		
		response.setData(listaDtos);		
		
		return ResponseEntity.ok(response);
		
	}
	
	@PutMapping(value = "v1/abrir")
	public ResponseEntity<String> abrirSessao(@RequestParam(required = true, value = "id") Long pId, @RequestParam(required = true, value = "minutos", defaultValue = "1") Long pTempo){
		
		pautaService.aberturaSessao(pId, pTempo);
		
		
		return ResponseEntity.ok("Data atualizada com sucesso!");
	}
	
	
	
	public PautaDTO converterParaDTO(PautaEntity pauta) {
		
		if(pauta == null)
			return null;
		
		PautaDTO output = new PautaDTO();
		
		output.setId(pauta.getId() != null ? pauta.getId() : null);
		output.setNome(pauta.getNome() != null ? pauta.getNome() : null);
		output.setDataFim(pauta.getDataFim() != null ? pauta.getDataFim().toString(): null);
		
		return output;
	}

}
