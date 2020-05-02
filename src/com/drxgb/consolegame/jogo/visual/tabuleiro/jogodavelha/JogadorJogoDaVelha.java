/**
 * Classe JogadorJogoDaVelha
 * <p>Responsável por controlar ações de um jogador
 * de um Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see JogadorTabuleiro
 * @see Jogador
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha;

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.JogoException;
import com.drxgb.consolegame.jogo.ia.IA;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogadorTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.PosicaoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.Tabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.TabuleiroIA;

public class JogadorJogoDaVelha extends JogadorTabuleiro {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */

	private Marca marca;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo jogador do Jogo da Velha
	 * @param nome -> nome do jogador
	 * @param ia -> o jogador é uma IA?
	 * @param marca -> marca do jogador
	 */
	public JogadorJogoDaVelha(String nome, boolean ia, Marca marca) {
		super(nome, ia);
		this.marca = marca;
	}
	
	/**
	 * <p><i>@Sobrecarga</i></p>
	 * Instancia um novo jogador do Jogo da Velha
	 * @param nome
	 * @param marca
	 */
	public JogadorJogoDaVelha(String nome, Marca marca) {
		this(nome, true, marca);
	}
	
	/**
	 * <p><i>@Sobrecarga</i></p>
	 * Instancia um novo jogador do Jogo da Velha
	 * @param ia -> o jogador é uma IA?
	 * @param marca -> marca do jogador
	 */
	public JogadorJogoDaVelha(boolean ia, Marca marca) {
		super(ia);
		this.marca = marca;
	}
	
	/**
	 * <p><i>@Sobrecarga</i></p>
	 * Instancia um novo jogador do Jogo da Velha 
	 * @param marca
	 */
	public JogadorJogoDaVelha(Marca marca) {
		super();
		this.marca = marca;
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Marca uma posição escolhida pelo argumento.
	 * @param posicao -> posição onde será marcada
	 */
	public void marcar(PosicaoTabuleiro posicao, Tabuleiro tabuleiro) {
		posicao.setPeca(new PecaJogoDaVelha(this.getMarca()));
		tabuleiro.setPeca(posicao);
	}	
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public void agir(Jogo jogo) {		
		if(this.isIA()) {
			IA ia = new JogoDaVelhaIA(jogo, this);
			this.marcar(
					((TabuleiroIA) ia).analisaTabuleiro(),
					((JogoTabuleiro) jogo).getTabuleiro()
				);
		} else {
			throw new JogoException("Este jogador não tem autorização para realizar ações de uma IA.");
		}
	}
	
	/*
	 * ========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ========================================================
	 */
	
	public Marca getMarca() {
		return marca;
	}
	
}
