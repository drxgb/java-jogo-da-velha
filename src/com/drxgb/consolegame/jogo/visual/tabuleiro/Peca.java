/**
 * Classe Peca
 * <p>Representa a inst�ncia de uma Pe�a em
 * um jogo de tabuleiro</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

public abstract class Peca {

	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova Pe�a.
	 */
	public Peca() {}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recupera informa��o de texto que representa uma pe�a.
	 * Pode ser uma frase, um nome, um n�mero, um c�digo ou,
	 * at� mesmo, um simples caractere.
	 * @return um nome ou um caractere representando esta pe�a
	 */
	public abstract String get();
	
}
