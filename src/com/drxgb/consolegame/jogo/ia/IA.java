/**
 * Classe IA
 * <p>Representa a inst�ncia da IA (Intelig�ncia Artificial)
 * de um jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.ia;

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.Jogo;

public abstract class IA {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Jogo jogo;
	protected Jogador jogador;
	
	 
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma nova Intelig�ncia Artificial (IA)
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 * @param jogador -> inst�ncia de <code>Jogador</code>
	 */
	public IA(Jogo jogo, Jogador jogador) {
		this.jogo = jogo;
		this.jogador = jogador;
	}
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Jogo getJogo() {
		return jogo;
	}
	
}
