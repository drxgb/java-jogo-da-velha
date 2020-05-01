/**
 * Classe PosicaoTabuleiro
 * <p>Responsável por tratar coordenadas de maneira
 * apropriada a um jogo de tabuleiro.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Posicao
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

import com.drxgb.consolegame.jogo.visual.Posicao;

public class PosicaoTabuleiro extends Posicao {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Peca peca;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova posição no tabuleiro
	 * @param x -> coordenada x do tabuleiro
	 * @param y -> coordenada y do tabuleiro
	 */
	public PosicaoTabuleiro(int x, int y) {
		super(x, y);
	}	
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}
