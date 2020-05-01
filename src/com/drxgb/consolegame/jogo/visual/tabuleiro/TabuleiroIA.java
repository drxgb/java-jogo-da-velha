/**
 * Classe TabuleiroIA
 * <p>Responsável por ações da IA de
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
	 * @param jogo -> instância de <code>Jogo</code>
	 */
	public TabuleiroIA(Jogo jogo) {
		super(jogo);
	}

	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Fará uma análise de todo o tabuleiro antes
	 * de realizar uma ação.
	 * @return uma <code>Posicao</code> onde a IA fará uma ação
	 */
	public abstract Posicao analisaTabuleiro();	
	
}
