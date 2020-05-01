/**
 * Classe TabuleiroIA
 * <p>Respons�vel por a��es da IA de
 * um jogo de tabuleiro</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see IA
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.ia.IA;
import com.drxgb.consolegame.jogo.visual.Posicao;

public abstract class TabuleiroIA extends IA {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	

	/**
	 * Instancia uma nova IA de um jogo de tabuleiro.
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 */
	public TabuleiroIA(Jogo jogo) {
		super(jogo);
	}

	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Far� uma an�lise de todo o tabuleiro antes
	 * de realizar uma a��o.
	 * @return uma <code>Posicao</code> onde a IA far� uma a��o
	 */
	public abstract Posicao analisaTabuleiro();	
	
}
