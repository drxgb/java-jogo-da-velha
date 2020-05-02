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

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.ia.IA;

public abstract class TabuleiroIA extends IA {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	

	/**
	 * Instancia uma nova IA de um jogo de tabuleiro.
	 * @param jogo -> instância do <code>Jogo</code>
	 * @param jogador -> instância de <code>Jogador</code>
	 */
	public TabuleiroIA(Jogo jogo, Jogador jogador) {
		super(jogo, jogador);
	}

	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Fará uma análise de todo o tabuleiro antes
	 * de realizar uma ação.
	 * @return uma <code>PosicaoTabuleiro</code> onde a IA fará uma ação
	 */
	public abstract PosicaoTabuleiro analisaTabuleiro();	
	
}
