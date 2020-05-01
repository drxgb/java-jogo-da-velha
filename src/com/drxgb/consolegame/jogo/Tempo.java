/**
 * Classe Tempo
 * <p>Respons�vel por manipular o tempo de jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo;

public final class Tempo {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Long inicio;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia um novo tempo, iniciando o contador de
	 * de tempo do jogo.
	 */
	public Tempo() {
		this.setInicio(System.currentTimeMillis());
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recupera a quantidade de milissegundos percorridos
	 * durante o jogo at� agora.
	 * @return milissegundos
	 */
	public Long getMillis() {
		return System.currentTimeMillis() - this.getInicio();
	}	
	
	/**
	 * Recupera a quantidade de segundos percorridos
	 * durante o jogo at� agora.
	 * @return segundos em decimal
	 */
	public double getSegundos() {
		return ((double) this.getMillis()) / 1000 % 60;
	}
	
	/**
	 * Recupera a quantidade de segundos percorridos
	 * durante o jogo at� agora.
	 * @return segundos em n�mero inteiro
	 */
	public int getIntSegundos() {
		return (int) this.getSegundos();
	}
	
	/**
	 * Recupera a quantidade de minutos percorridos
	 * durante o jogo at� agora.
	 * @return minutos em decimal
	 */
	public double getMinutos() {
		return ((double) this.getMillis()) / 1000 / 60 % 60;
	}
	
	/**
	 * Recupera a quantidade de minutos percorridos
	 * durante o jogo at� agora.
	 * @return minutos em n�mero inteiro
	 */
	public int getIntMinutos() {
		return (int) this.getMinutos();
	}
	
	/**
	 * Recupera a quantidade de horas percorridas
	 * durante o jogo at� agora.
	 * @return horas em decimal
	 */
	public double getHoras() {
		return ((double) this.getMillis()) / 1000 / 60 / 60;
	}
	
	/**
	 * Recupera a quantidade de horas percorridas
	 * durante o jogo at� agora.
	 * @return horas em n�mero inteiro
	 */
	public int getIntHoras() {
		return (int) this.getHoras();
	}
	
	/*
	 * ========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ========================================================
	 */
	
	public Long getInicio() {
		return inicio;
	}

	private void setInicio(Long inicio) {
		this.inicio = inicio;
	}

}
