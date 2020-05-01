/**
 * Classe Jogo
 * <p>Representa a instanciação de um jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Jogo {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected String nome;
	protected Integer turnos;
	protected boolean encerrado;
	protected List<Jogador> jogadores = new ArrayList<>();
	protected Tempo tempo;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo jogo.
	 * @param nome -> nome do jogo
	 */
	public Jogo(String nome) {
		this.nome = nome;
		this.turnos = 1;
		this.encerrado = false;
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia um novo jogo.
	 * @param nome
	 * @param jogadores
	 */
	public Jogo(String nome, List<Jogador> jogadores) {
		this(nome);
		this.jogadores = jogadores;
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia um novo jogo.
	 * @param nome
	 * @param jogador
	 */
	public Jogo(String nome, Jogador jogador) {
		this(nome);
		this.registraJogador(jogador);
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Inicia a contagem de tempo do jogo
	 */
	public void iniciaTempo() {
		this.tempo = new Tempo();
	}
	
	/**
	 * Passa para o próximo turno.
	 */
	public void proximoTurno() {
		this.turnos++;
	}
	
	/**
	 * Registra um novo jogador nesta partida.
	 * @param jogador -> instância <code>Jogador</code>
	 */
	public void registraJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	/**
	 * Remove um jogador desta partida.
	 * @param jogador -> instância <code>Jogador</code>
	 */
	public void removeJogador(Jogador jogador) {
		this.jogadores.remove(jogador);
	}
	
	/**
	 * Recebe a instância de <code>Jogador</code> através de um predicado.
	 * @param predicate -> função de filtro de um jogador
	 * @return uma instância de <code>Jogador</code>
	 */
	public Jogador getJogador(Predicate<? super Jogador> predicate) {
		return this.jogadores.stream().filter(predicate).findFirst().get();
	}
	
	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public String getNome() {
		return nome;
	}

	public Integer getTurnos() {
		return turnos;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public boolean isEncerrado() {
		return encerrado;
	}

	public void setEncerrado(boolean encerrado) {
		this.encerrado = encerrado;
	}

	public Tempo getTempo() {
		return tempo;
	}
	
}
