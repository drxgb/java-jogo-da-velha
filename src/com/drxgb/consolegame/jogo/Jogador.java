/**
 * Classe Jogador
 * <p>Representa uma instância genérica
 * de um jogador</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see AcaoIA
 */

package com.drxgb.consolegame.jogo;

import com.drxgb.consolegame.jogo.ia.AcaoIA;

public abstract class Jogador implements AcaoIA {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */

	protected String nome;
	protected Boolean ia;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo jogador.
	 * @param nome -> nome do jogador
	 * @param ia -> se o jogador é uma IA
	 */
	public Jogador(String nome, boolean ia) {
		this.nome = nome;
		this.ia = ia;
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia um novo jogador.
	 * @param ia -> se o jogador é uma IA
	 */
	public Jogador(boolean ia) {
		this("Jogador", ia);
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia um novo jogador.
	 */
	public Jogador() {
		this("CPU", true);
	}
	
	/*
	 * ========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ========================================================
	 */

	public String getNome() {
		return nome;
	}

	public Boolean isIA() {
		return ia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
