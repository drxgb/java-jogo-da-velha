/**
 * Classe ConsoleTabuleiro
 * <p>Respons�vel por controlar a��es de um
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
	 * Instancia uma aplica��o terminal de tabuleiro.
	 */
	public ConsoleTabuleiro() {
		super();
	}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Registra o tabuleiro utilizado no jogo.
	 */
	public abstract void registraTabuleiro();
	
}
