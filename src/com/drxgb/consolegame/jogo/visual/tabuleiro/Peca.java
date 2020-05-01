/**
 * Classe Peca
 * <p>Representa a instância de uma Peça em
 * um jogo de tabuleiro</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

public abstract class Peca {

	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova Peça.
	 */
	public Peca() {}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recupera informação de texto que representa uma peça.
	 * Pode ser uma frase, um nome, um número, um código ou,
	 * até mesmo, um simples caractere.
	 * @return um nome ou um caractere representando esta peça
	 */
	public abstract String get();
	
}
