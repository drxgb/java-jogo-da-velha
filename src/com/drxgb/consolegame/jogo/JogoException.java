/**
 * Exceção JogoException
 * <p>Classe usada para tratar erros relacionados ao jogo.</p>
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo;

public class JogoException extends RuntimeException {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public JogoException(String msg) {
		super(msg);
	}

}
