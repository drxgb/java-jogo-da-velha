/**
 * Classe ConsoleTabuleiro
 * <p>Responsável por controlar ações de um
 * jogo de Tabuleiro para Console.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Console
 */

package com.drxgb.consolegame.app.console;

public abstract class ConsoleTabuleiro extends Console {

	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma aplicação terminal de tabuleiro.
	 */
	public ConsoleTabuleiro() {
		super();
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Registra o tabuleiro utilizado no jogo.
	 */
	public abstract void registraTabuleiro();
	
}
