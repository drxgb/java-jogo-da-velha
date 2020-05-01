/**
 * Classe JogoDaVelha
 * <p>Respons�vel por controlar a��es de
 * um Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see JogoTabuleiro
 * @see JogoVisual
 * @see Jogo
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;

public class JogoDaVelha extends JogoTabuleiro {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */

	/**
	 * Instancia um novo Jogo da Velha.
	 * @param nome -> nome do jogo
	 */
	public JogoDaVelha(String nome) {
		super(nome, null);
	}
	
	/**
	 * <i>@{Sobrescrita}</i>
	 * Instancia um novo Jogo da Velha com um nome padr�o.
	 */
	public JogoDaVelha() {
		this("Jogo da Velha");
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Analisa todas as linhas do tabuleiro checando se h�
	 * alguma linha preenchida pela mesma marca do jogador.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return se alguma linha est� toda marcada pelo mesmo jogador
	 */
	private boolean leituraHorizontal(JogadorJogoDaVelha jogador) {
		for(int l = 0; l < this.tabuleiro.getLargura(); l++) {
			List<PecaJogoDaVelha> pecas = new ArrayList<>();
			
			for(int c = 0; c < this.tabuleiro.getComprimento(); c++) {
				pecas.add((PecaJogoDaVelha) this.tabuleiro.getPeca(c, l));
			}
			
			if(this.pecasIguais(pecas, jogador))
				return true;	
		}
		return false;
	}
	
	/**
	 * Analisa todas as colunas do tabuleiro checando se h�
	 * alguma coluna preenchida pela mesma marca do jogador.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return se alguma coluna est� toda marcada pelo mesmo jogador
	 */
	private boolean leituraVertical(JogadorJogoDaVelha jogador) {
		for(int c = 0; c < this.tabuleiro.getComprimento(); c++) {
			List<PecaJogoDaVelha> pecas = new ArrayList<>();
			
			for(int l = 0; l < this.tabuleiro.getLargura(); l++) {
				pecas.add((PecaJogoDaVelha) this.tabuleiro.getPeca(c, l));
			}
						
			if(this.pecasIguais(pecas, jogador))
				return true;					
		}
		return false;
	}
	
	/**
	 * Analisa as duas diagonais do tabuleiro verificando se
	 * uma delas est� preenchida pela mesma marca do jogador.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return se uma das duas diagonais est�o marcadas pelo mesmo jogador
	 */
	private boolean leituraDiagonal(JogadorJogoDaVelha jogador) {
		List<PecaJogoDaVelha> pecas = new ArrayList<>();
		
		// Diagonal Principal
		for(int i = 0; i < this.tabuleiro.getComprimento(); i++) {
			pecas.add((PecaJogoDaVelha) this.tabuleiro.getPeca(i));
		}
		if(this.pecasIguais(pecas, jogador))
			return true;
		
		// Diagonal Principal Reversa
		pecas.clear();
		int l = 0;
		for(int c = (this.tabuleiro.getComprimento() - 1); c >= 0 ; c--) {
			pecas.add((PecaJogoDaVelha) this.tabuleiro.getPeca(c, l++));
		}
		if(this.pecasIguais(pecas, jogador))
			return true;
		
		// Se nenhuma diagonal id�ntica foi encontrada,
		// o jogo segue normalmente.
		return false;
	}
	
	/**
	 * Analisa se o tabuleiro est� cheio.
	 * @return se o tabuleiro est� cheio ou n�o
	 */
	private boolean tabuleiroCheio() {		
		for(int l = 0; l < this.tabuleiro.getLargura(); l++) {
			for(int c = 0; c < this.tabuleiro.getComprimento(); c++) {
				if(!this.tabuleiro.temPeca(c, l)) {					
					return false; // Tabuleiro ainda N�O est� cheio
				}
			}
		}		
		return true; // Tabuleiro est� cheio
	}
	
	/**
	 * Compara a igualdade entre um conjunto de pe�as.
	 * @param pecas -> conjunto de pe�as a serem comparadas
	 * @param jogador -> inst�ncia de<code>JogadorJogoDaVelha</code>
	 * @return se todas pe�as do conjunto s�o iguais
	 */
	private boolean pecasIguais(List<PecaJogoDaVelha> pecas, JogadorJogoDaVelha jogador) {
		List<PecaJogoDaVelha> pecasIguais = pecas.stream()
				.filter(x -> x != null && (x.getMarca() == jogador.getMarca()))
				.collect(Collectors.toList());
		return pecasIguais.equals(pecas);
	}

	/*
	 * ===========================================================
	 * 				*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public boolean jogadaFinal() {		
		// Analisar poss�veis vit�rias de um dos jogadores
		for(Jogador jogador : this.jogadores) {
			if(
				this.leituraHorizontal((JogadorJogoDaVelha) jogador) ||
				this.leituraVertical((JogadorJogoDaVelha) jogador) ||
				this.leituraDiagonal((JogadorJogoDaVelha) jogador)
			) {
				this.setVencedor(jogador);
				return true;
			}
		}		
		
		// Analisar empate
		if(this.tabuleiroCheio())
			return true;
		
		// Se nenhuma dessas condi��es foram atendidas,
		// quer dizer que o jogo ainda n�o acabou
		return false;
	}

}
