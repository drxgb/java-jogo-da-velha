/**
 * Classe IA
 * <p>Representa a instância da IA (Inteligência Artificial)
 * de um jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.ia;

import com.drxgb.consolegame.jogo.Jogo;

public abstract class IA {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Jogo jogo;
	
	 
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	public IA(Jogo jogo) {
		this.jogo = jogo;
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
