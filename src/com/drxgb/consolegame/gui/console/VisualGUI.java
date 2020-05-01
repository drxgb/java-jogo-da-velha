/**
 * Classe VisualGUI
 * <p>Controla as ações de um jogo visual</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see GUI
 */

package com.drxgb.consolegame.gui.console;

import java.util.Scanner;

import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.visual.Posicao;

public abstract class VisualGUI extends GUI {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Character separadorColuna;
	protected Character separadorLinha;
	protected Character espacoVazio;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma nova interface gráfica visual
	 * @param jogo -> instância de <code>Jogo</code>
	 * @param separadorColuna -> caractere definido para ser o separador das colunas
	 * @param separadorLinha -> caractere definido para ser o separador das linhas
	 * @param espacoVazio -> caractere definido para ser o espaço vazio
	 * @param borda -> a interface terá uma borda ou não?
	 */
	public VisualGUI(
			Jogo jogo,
			Character separadorColuna,
			Character separadorLinha,
			Character espacoVazio
	) {
		super(jogo);
		this.separadorColuna = separadorColuna;
		this.separadorLinha = separadorLinha;
		this.espacoVazio = espacoVazio;
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia uma nova interface gráfica visual
	 * @param jogo -> instância de <code>Jogo</code>
	 */
	public VisualGUI(Jogo jogo) {
		this(jogo, null, null, null);
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PROTEGIDOS ***
	 * ===========================================================
	 */	
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Desenha a legenda das colunas.
	 * @param -> a tela terá borda ou não?
	 */
	protected void desenhaColunas() {
		this.desenhaColunas(false);
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Desenha a legenda das linhas.
	 * @param -> a tela terá borda ou não?
	 */
	protected void desenhaLinhas() {
		this.desenhaLinhas(false);
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */	

	/**
	 * Mostra uma tela onde o usuário pode escolher uma posição
	 * na tela do jogo.
	 * @param sc -> instância de <code>Scanner</code> para
	 * receber um valor.
	 * @return a posição selecionada
	 */
	public abstract Posicao escolhePosicao(Scanner sc);
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PROTEGIDOS ABSTRATOS ***
	 * ===========================================================
	 */	
	
	/**
	 * Desenha a legenda das colunas.
	 * @param -> a tela terá borda ou não?
	 */
	protected abstract void desenhaColunas(boolean borda);
	
	/**
	 * Desenha a legenda das linhas.
	 * @param -> a tela terá borda ou não?
	 */
	protected abstract void desenhaLinhas(boolean borda);
	
	/**
	 * Desenha a linha separadora na tela.
	 * @param -> a tela terá borda ou não?
	 */
	protected abstract void desenhaLinhaSeparadora(boolean borda);
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Character getSeparadorColuna() {
		return separadorColuna;
	}

	public Character getSeparadorLinha() {
		return separadorLinha;
	}

	public Character getEspacoVazio() {
		return espacoVazio;
	}

	public void setSeparadorColuna(Character separadorColuna) {
		this.separadorColuna = separadorColuna;
	}

	public void setSeparadorLinha(Character separadorLinha) {
		this.separadorLinha = separadorLinha;
	}

	public void setEspacoVazio(Character espacoVazio) {
		this.espacoVazio = espacoVazio;
	}
	
}

