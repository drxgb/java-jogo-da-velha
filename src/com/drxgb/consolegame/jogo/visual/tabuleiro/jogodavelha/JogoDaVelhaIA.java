/**
 * Classe JogoDaVelhaIA
 * <p>Respons�vel por controlar a IA de
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
	 * @param jogo -> inst�ncia do jogo
	 */
	public JogoDaVelhaIA(Jogo jogo) {
		super(jogo);
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica a possibilidade da IA realizar a �ltima jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * ser� retornada uma inst�ncia de <code>Posicao</code>.
	 * Se a IA ainda n�o tem como vencer a partida, ser�
	 * retornado o valor <code>null</code>.
	 * @return uma posi��o dispon�vel para realizar a jogada
	 */
	private Posicao jogadaFinal() {
		// TODO jogada Final
		return null;
	}
	
	/**
	 * Verifica a possibilidade do Oponente realizar a �ltima jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * ser� retornada uma inst�ncia de <code>Posicao</code>.
	 * Se o oponente ainda n�o tem como vencer a partida, ser�
	 * retornado o valor <code>null</code>.
	 * @return uma posi��o dispon�vel para realizar a jogada
	 */
	private Posicao jogadaFinalOponente() {
		// TODO jogada Final do Oponente
		return null;
	}
	
	/**
	 * Verifica se a IA j� marcou em algumas casa para
	 * poder marcar uma casa vizinha de sua marca.
	 * Se a sua marca for encontrada, ser� escolhida
	 * aleatoriamente uma <code>Posicao</code>. Se
	 * nenhuma marca da IA foi encontrada, ser� retornado
	 * o valor <code>null</code>.
	 * @return uma posi��o dispon�vel para realizar a jogada
	 */
	private Posicao buscaPosciaoMarcada() {
		// TODO buscar pela posi��o marcada
		return null;
	}
	
	/**
	 * A IA escolher� uma casa aleatoriamente e retornar�
	 * uma <code>Posicao</code> para ser marcada.
	 * @return uma posi��o dispon�vel para realizar a jogada
	 */
	private Posicao escolheQualquerCasa() {
		// TODO escolher qualquer casa
		return null;
	}
	
	/**
	 * Verifica se h� alguma linha que est� prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornar� uma <code>Posicao</code>
	 * para ser marcada. Se n�o encontrar nenhuma casa amea�ada,
	 * retornar� <code>null</code>.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return uma posi��o poss�vel para uma jogada final
	 */
	private Posicao verificaHorizontal(JogadorJogoDaVelha jogador) {
		// TODO verifica��o horizontal
		return null;
	}
	
	/**
	 * Verifica se h� alguma coluna que est� prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornar� uma <code>Posicao</code>
	 * para ser marcada. Se n�o encontrar nenhuma casa amea�ada,
	 * retornar� <code>null</code>.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return uma posi��o poss�vel para uma jogada final
	 */
	private Posicao verificaVertical(JogadorJogoDaVelha jogador) {
		// TODO verifica��o vertical
		return null;
	}
	
	/**
	 * Verifica se h� alguma diagonal que est� prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornar� uma <code>Posicao</code>
	 * para ser marcada. Se n�o encontrar nenhuma casa amea�ada,
	 * retornar� <code>null</code>.
	 * @param jogador -> inst�ncia de <code>JogadorJogoDaVelha</code>
	 * @return uma posi��o poss�vel para uma jogada final
	 */
	private Posicao verificaDiagonal(JogadorJogoDaVelha jogador) {
		// TODO verifica��o diagonal
		return null;
	}
	
	/**
	 * Verifica��o de um conjunto de pe�as, cujo este deve ter
	 * somente um dos espa�os vazios para que a IA possa
	 * confirmar sua jogado final.
	 * @param pecas -> conjunto de pe�as
	 * @param jogador -> inst�ncia de <code>Jogador</code>
	 * @return se o conjunto h� pe�as iguais e um espa�o vazio
	 */
	private boolean comparaPecas(List<PecaJogoDaVelha> pecas, JogadorJogoDaVelha jogador) {
		// TODO comparar pe�as
		return false;
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public Posicao analisaTabuleiro() {
		// TODO analisar tabuleiro
		return null;
	}
	
}
