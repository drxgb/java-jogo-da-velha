/**
 * Classe PecaJogoDaVelha
 * <p>Representa um pe�a de um
 * Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Peca
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha;

import com.drxgb.consolegame.jogo.visual.tabuleiro.Peca;

public class PecaJogoDaVelha extends Peca {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Marca marca;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Insatncia uma nova Pe�a do Jogo da Velha
	 * @param marca -> a marca representada por esta pe�a
	 */
	public PecaJogoDaVelha(Marca marca) {
		this.marca = marca;
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public String get() {
		return (this.marca != null) ? this.getMarca().toString() : " ";
	}
	
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public Marca getMarca() {
		return marca;
	}
	
}
