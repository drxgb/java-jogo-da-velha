/**
 * Classe Posicao
 * <p>Responsável por armazenar coordenadas
 * do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.visual;

public class Posicao {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected int x;
	protected int y;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova posição
	 * @param x -> coordenada X
	 * @param y -> coordenada Y
	 */
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
