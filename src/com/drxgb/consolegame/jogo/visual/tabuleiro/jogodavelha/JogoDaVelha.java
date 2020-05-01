/**
 * Classe JogoDaVelha
 * <p>Responsável por controlar ações de
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
	 * Instancia um novo Jogo da Velha com um nome padrão.
	 */
	public JogoDaVelha() {
		this("Jogo da Velha");
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Analisa todas as linhas do tabuleiro checando se há
	 * alguma linha preenchida pela mesma marca do jogador.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return se alguma linha está toda marcada pelo mesmo jogador
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
	 * Analisa todas as colunas do tabuleiro checando se há
	 * alguma coluna preenchida pela mesma marca do jogador.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return se alguma coluna está toda marcada pelo mesmo jogador
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
	 * uma delas está preenchida pela mesma marca do jogador.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return se uma das duas diagonais estão marcadas pelo mesmo jogador
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
		
		// Se nenhuma diagonal idêntica foi encontrada,
		// o jogo segue normalmente.
		return false;
	}
	
	/**
	 * Analisa se o tabuleiro está cheio.
	 * @return se o tabuleiro está cheio ou não
	 */
	private boolean tabuleiroCheio() {		
		for(int l = 0; l < this.tabuleiro.getLargura(); l++) {
			for(int c = 0; c < this.tabuleiro.getComprimento(); c++) {
				if(!this.tabuleiro.temPeca(c, l)) {					
					return false; // Tabuleiro ainda NÃO está cheio
				}
			}
		}		
		return true; // Tabuleiro está cheio
	}
	
	/**
	 * Compara a igualdade entre um conjunto de peças.
	 * @param pecas -> conjunto de peças a serem comparadas
	 * @param jogador -> instância de<code>JogadorJogoDaVelha</code>
	 * @return se todas peças do conjunto são iguais
	 */
	private boolean pecasIguais(List<PecaJogoDaVelha> pecas, JogadorJogoDaVelha jogador) {
		List<PecaJogoDaVelha> pecasIguais = pecas.stream()
				.filter(x -> x != null && (x.getMarca() == jogador.getMarca()))
				.collect(Collectors.toList());
		return pecasIguais.equals(pecas);
	}

	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public boolean jogadaFinal() {		
		// Analisar possíveis vitórias de um dos jogadores
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
		
		// Se nenhuma dessas condições foram atendidas,
		// quer dizer que o jogo ainda não acabou
		return false;
	}

}
