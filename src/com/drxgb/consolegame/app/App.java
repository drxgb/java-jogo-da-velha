/**
 * Classe App
 * <p>Responsável por controlar toda a aplicação Java.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see Eventos
 */

package com.drxgb.consolegame.app;

public abstract class App implements Eventos {

	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma nova aplicação Java.
	 */
	public App() {
		this.executar();
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Executa os eventos da aplicação.
	 */
	public void executar() {
		this.iniciar();
		this.atualizar();
		this.encerrar();
	}
	
	
}
