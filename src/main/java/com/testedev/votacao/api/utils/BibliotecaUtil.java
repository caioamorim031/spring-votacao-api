package com.testedev.votacao.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Biblioteca de Util utilizada para facilitar verificações, validações, etc.
 * @author Caio
 *
 */
public class BibliotecaUtil {
	
	
	/**
	 * Valida se a entrada do valor numérico é valida
	 * @param valorInformado
	 * @return
	 */
	public static boolean isValorValido(Long valorInformado) {
		
		if(valorInformado != null) {
			if(valorInformado > 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param pValor
	 * @return
	 */
	public static String addMinutosInSysdate(Long pValor) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.MINUTE, Integer.parseInt(pValor.toString()));
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}
	
	/**
	 * Valida a entrada da informação
	 * 
	 * @param pValor | Valor a ser verificado
	 * @param isValorAllowed | Pode aceitar caracteres especiais ou valores numéricos 
	 * @return
	 */
	public static boolean isEntradaValida(String pValor, boolean isValorAllowed) {
		if(pValor != null) {
			if(!pValor.isBlank()) {
				if(isValorAllowed 
						|| (!isValorAllowed && !contemNumeroOuEspeciais(pValor)) ) {
					return true;					
				} 
			}
		}
		return false;
	}
	
	/**
	 * Validação de Strings via Regex
	 * Segue alguns casos onde retorna true:
	 * 
	 * "Teste Caso"
	 * "Teste"
	 * "Teste t"
	 * 
	 *  Alguns casos onde retorna false:
	 * "Teste 1"
	 * "Teste "
	 * Espaço em branco
	 * "T#ste"
	 * 
	 * @param pValor
	 * @return true caso a String possua apenas caracteres e finalize com os mesmos, podendo conter espaços no meio, caso contrário, retorna false
	 */
	public static boolean contemNumeroOuEspeciais(String pValor) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z]+(\\s*[a-zA-Z])+$");
		
		return !pattern.matcher(pValor).find();
		
	}
}
