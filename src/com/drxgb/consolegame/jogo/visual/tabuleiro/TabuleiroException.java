/**
 * Exceção TabuleiroException
 * <p>Responsável por tratar erros relacionados
 * ao <code>Tabuleiro</code></p>
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

public class TabuleiroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public TabuleiroException(String msg) {
		super(msg);
	}

}
