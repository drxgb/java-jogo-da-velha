/**
 * Classe Tabuleiro
 * <p>Representa a inst�ncia de um tabuleiro</p>
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

import com.drxgb.consolegame.jogo.visual.Posicao;

public abstract class Tabuleiro {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Peca[][] pecas;
	protected int comprimento;
	protected int largura;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo tabuleiro.
	 * @param comprimento -> comprimento do tabuleiro
	 * @param largura -> largura do tabuleiro
	 */
	public Tabuleiro(int comprimento, int largura) {
		this.comprimento = comprimento;
		this.largura = largura;
		this.pecas = new Peca[this.comprimento][this.largura];
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * Instancia um novo tabuleiro de tamanho quadrado.
	 * @param tamanho -> tamanho do tabuleiro (Ex: 4x4, 8x8, 3x3, etc.)
	 */
	public Tabuleiro(int tamanho) {
		this(tamanho, tamanho);
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * Instancia um novo tabuleiro sem tamanho.
	 */
	public Tabuleiro() {
		this(1, 1);
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Escolhe uma pe�a em uma determinada posi��o
	 * do tabuleiro.
	 * @param x -> posi��o X do tabuleiro
	 * @param y -> posi��o Y do tabuleiro
	 * @return uma inst�ncia de <code>Peca</code>.<br>
	 * Se n�o tiver nenhuma pe�a nesta posi��o, ser�
	 * retornado o valor <code>null</code>.
	 */
	public Peca getPeca(int x, int y) {
		return this.getPecas()[x][y];
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * Escolhe uma pe�a em uma determinada posi��o
	 * do tabuleiro.
	 * @param posicao -> uma posi��o do tabuleiro
	 * @return uma inst�ncia de <code>Peca</code>.<br>
	 * Se n�o tiver nenhuma pe�a nesta posi��o, ser�
	 * retornado o valor <code>null</code>.
	 */
	public Peca getPeca(Posicao posicao) {
		return this.getPeca(posicao.getX(), posicao.getY());
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * Escolhe uma pe�a em uma determinada posi��o
	 * diagonal do tabuleiro.
	 * @param d -> posi��o diagonal do tabuleiro
	 * @return uma inst�ncia de <code>Peca</code>.<br>
	 * Se n�o tiver nenhuma pe�a nesta posi��o, ser�
	 * retornado o valor <code>null</code>.
	 */
	public Peca getPeca(int d) {
		return this.getPeca(d, d);
	}
	
	/**
	 * Coloca uma nova pe�a em uma posi��o.	 * @param posicao -> instancia de <code>Posicao</code>
	 */
	public void setPeca(PosicaoTabuleiro posicao) throws ArrayIndexOutOfBoundsException {
		this.pecas[posicao.getX()][posicao.getY()] = posicao.getPeca();
	}
	
	/**
	 * Verifica se a posi��o est� ocupada por uma <code>Peca</code>
	 * @param x -> posi��o X
	 * @param y -> posi��o Y
	 * @return se nesta posi��o h� uma pe�a ou n�o
	 */
	public boolean temPeca(int x, int y) {
		return this.getPeca(x, y) != null;
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * @param posicao -> inst�ncia de <code>Posicao</code>
	 * @return se nesta posi��o h� uma pe�a ou n�o
	 */
	public boolean temPeca(Posicao posicao) {
		return this.temPeca(posicao.getX(), posicao.getY());
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS PROTEGIDOS ***
	 * ===========================================================
	 */
	
	/**
	 * Instanciam-se novas posi��es preenchendo todo o espa�o
	 * do tabuleiro.
	 */
	protected void gerarPosicoes() {
		for(int lin = 0; lin < this.largura; lin++) {
			for(int col = 0; col < this.comprimento; col++) {
				this.pecas[col][lin] = null;
			}
		}
	}
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Peca[][] getPecas() {
		return pecas;
	}

	public int getComprimento() {
		return comprimento;
	}

	public int getLargura() {
		return largura;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}	
	
}
