/**
 * Classe JogoDaVelhaIA
 * <p>Responsável por controlar a IA de
 * um Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see TabuleiroIA
 * @see IA
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha;

import java.util.List;

import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.visual.Posicao;
import com.drxgb.consolegame.jogo.visual.tabuleiro.TabuleiroIA;

public class JogoDaVelhaIA extends TabuleiroIA {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	

	/**
	 * Instancia uma IA para o Jogo Da Velha
	 * @param jogo -> instância do jogo
	 */
	public JogoDaVelhaIA(Jogo jogo) {
		super(jogo);
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica a possibilidade da IA realizar a última jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * será retornada uma instância de <code>Posicao</code>.
	 * Se a IA ainda não tem como vencer a partida, será
	 * retornado o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private Posicao jogadaFinal() {
		// TODO jogada Final
		return null;
	}
	
	/**
	 * Verifica a possibilidade do Oponente realizar a última jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * será retornada uma instância de <code>Posicao</code>.
	 * Se o oponente ainda não tem como vencer a partida, será
	 * retornado o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private Posicao jogadaFinalOponente() {
		// TODO jogada Final do Oponente
		return null;
	}
	
	/**
	 * Verifica se a IA já marcou em algumas casa para
	 * poder marcar uma casa vizinha de sua marca.
	 * Se a sua marca for encontrada, será escolhida
	 * aleatoriamente uma <code>Posicao</code>. Se
	 * nenhuma marca da IA foi encontrada, será retornado
	 * o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private Posicao buscaPosciaoMarcada() {
		// TODO buscar pela posição marcada
		return null;
	}
	
	/**
	 * A IA escolherá uma casa aleatoriamente e retornará
	 * uma <code>Posicao</code> para ser marcada.
	 * @return uma posição disponível para realizar a jogada
	 */
	private Posicao escolheQualquerCasa() {
		// TODO escolher qualquer casa
		return null;
	}
	
	/**
	 * Verifica se há alguma linha que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private Posicao verificaHorizontal(JogadorJogoDaVelha jogador) {
		// TODO verificação horizontal
		return null;
	}
	
	/**
	 * Verifica se há alguma coluna que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private Posicao verificaVertical(JogadorJogoDaVelha jogador) {
		// TODO verificação vertical
		return null;
	}
	
	/**
	 * Verifica se há alguma diagonal que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private Posicao verificaDiagonal(JogadorJogoDaVelha jogador) {
		// TODO verificação diagonal
		return null;
	}
	
	/**
	 * Verificação de um conjunto de peças, cujo este deve ter
	 * somente um dos espaços vazios para que a IA possa
	 * confirmar sua jogado final.
	 * @param pecas -> conjunto de peças
	 * @param jogador -> instância de <code>Jogador</code>
	 * @return se o conjunto há peças iguais e um espaço vazio
	 */
	private boolean comparaPecas(List<PecaJogoDaVelha> pecas, JogadorJogoDaVelha jogador) {
		// TODO comparar peças
		return false;
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public Posicao analisaTabuleiro() {
		// TODO analisar tabuleiro
		return null;
	}
	
}
