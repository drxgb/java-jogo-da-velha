/**
 * Classe JogoTabuleiro
 * <p>Representa a instância de um
 * jogo de tabuleiro</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see JogoVisual
 * @see Jogo
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro;

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.visual.JogoVisual;
import com.drxgb.consolegame.jogo.visual.Posicao;

public abstract class JogoTabuleiro extends JogoVisual {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Jogador vez;
	protected Jogador vencedor;
	protected Tabuleiro tabuleiro;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo jogo de tabuleiro.
	 * @param nome -> nome do jogo
	 * @param jogador -> instância do <code>Jogador</code>
	 */
	public JogoTabuleiro(String nome) {
		this(nome, null);
	}
	
	/**
	 * <i>@{Sobrescrita}</i>
	 * Instancia um novo jogo de tabuleiro.
	 * @param nome -> nome do jogo
	 * @param tabuleiro -> instância de <code>Tabuleiro</code>
	 */
	public JogoTabuleiro(String nome, Tabuleiro tabuleiro) {
		super(nome);
		this.tabuleiro = tabuleiro;
	}	
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Analisa a possibilidade de ter um espaço vazio no
	 * tabuleiro.
	 * @param posicao -> posição onde será feita a análise
	 * @return se tem um espaço vazio ou não
	 */
	public boolean temEspacoVazio(Posicao posicao) {
		return !this.tabuleiro.temPeca(posicao);
	}
	
	/**
	 * Troca a vez do jogador.
	 * @param jogador -> o novo <code>Jogador</code>
	 */
	public void trocaVez(Jogador jogador) {
		this.vez = jogador;
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Troca a vez para o próximo jogador.
	 */
	public void trocaVez() {
		int n = this.jogadores.indexOf(this.vez) + 1;
		if(n >= this.jogadores.size())
			n = 0;
		this.trocaVez(this.jogadores.get(n));
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	public abstract boolean jogadaFinal();
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Jogador getVez() {
		return vez;
	}

	public Jogador getVencedor() {
		return vencedor;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setVencedor(Jogador vencedor) {
		this.vencedor = vencedor;
	}	

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.trocaVez(this.jogadores.get(0));
	}	
	
}
