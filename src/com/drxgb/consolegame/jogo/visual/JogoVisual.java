/**
 * Classe JogoVisual
 * <p>Responsável por controlar ações de
 * um jogo com interface gráfica</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Jogo
 */

package com.drxgb.consolegame.jogo.visual;

import com.drxgb.consolegame.jogo.Jogo;

public abstract class JogoVisual extends Jogo {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Integer comprimento;
	protected Integer largura;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */

	/**
	 * Instancia um novo Jogo de tipo Visual sem
	 * determinar as dimensões da tela.
	 * @param nome -> nome do jogo
	 */
	public JogoVisual(String nome) {
		super(nome);
	}
	
	/**
	 * <i>@Sobrecarga/i><br>
	 * Instancia um novo Jogo de tipo Visual.
	 * @param nome -> nome do jogo
	 * @param comprimento -> comprimento da tela do jogo
	 * @param largura -> largura da tela do jogo
	 */
	public JogoVisual(String nome, int comprimento, int largura) {
		this(nome);
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Integer getComprimento() {
		return comprimento;
	}

	public Integer getLargura() {
		return largura;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	public void setLargura(Integer largura) {
		this.largura = largura;
	}	

}
