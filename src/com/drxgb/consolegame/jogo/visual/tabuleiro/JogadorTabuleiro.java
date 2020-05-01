/**
 * Classe JogadorTabuleiro
 * <p>Representa ações de um jogador de tabuleiro</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Jogador
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

import com.drxgb.consolegame.jogo.Jogador;

public abstract class JogadorTabuleiro extends Jogador {

	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	
	/**
	 * Instancia um novo Jogador de Tabuleiro
	 * @param nome -> nome do jogador
	 * @param ia -> se o jogador é uma IA
	 */
	public JogadorTabuleiro(String nome, boolean ia) {
		super(nome, ia);
	}
	
	/**
	 * <i>{@Sobrecarga}</i>
	 * Instancia um novo Jogador de Tabuleiro
	 * @param ia -> se o jogador é uma IA
	 */
	public JogadorTabuleiro(boolean ia) {
		super(ia);
	}

	/**
	 * <i>{@Sobrecarga}</i>
	 * Instancia um novo Jogador de Tabuleiro
	 */
	public JogadorTabuleiro() {
		super();
	}
	
}
