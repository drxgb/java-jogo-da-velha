/**
 * Classe Tempo
 * <p>Responsável por manipular o tempo de jogo</p>
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
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recupera a quantidade de milissegundos percorridos
	 * durante o jogo até agora.
	 * @return milissegundos
	 */
	public Long getMillis() {
		return System.currentTimeMillis() - this.getInicio();
	}	
	
	/**
	 * Recupera a quantidade de segundos percorridos
	 * durante o jogo até agora.
	 * @return segundos em decimal
	 */
	public double getSegundos() {
		return ((double) this.getMillis()) / 1000 % 60;
	}
	
	/**
	 * Recupera a quantidade de segundos percorridos
	 * durante o jogo até agora.
	 * @return segundos em número inteiro
	 */
	public int getIntSegundos() {
		return (int) this.getSegundos();
	}
	
	/**
	 * Recupera a quantidade de minutos percorridos
	 * durante o jogo até agora.
	 * @return minutos em decimal
	 */
	public double getMinutos() {
		return ((double) this.getMillis()) / 1000 / 60 % 60;
	}
	
	/**
	 * Recupera a quantidade de minutos percorridos
	 * durante o jogo até agora.
	 * @return minutos em número inteiro
	 */
	public int getIntMinutos() {
		return (int) this.getMinutos();
	}
	
	/**
	 * Recupera a quantidade de horas percorridas
	 * durante o jogo até agora.
	 * @return horas em decimal
	 */
	public double getHoras() {
		return ((double) this.getMillis()) / 1000 / 60 / 60;
	}
	
	/**
	 * Recupera a quantidade de horas percorridas
	 * durante o jogo até agora.
	 * @return horas em número inteiro
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
