/**
 * Classe App
 * <p>Respons�vel por controlar toda a aplica��o Java.</p>
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
	 * Instancia uma nova aplica��o Java.
	 */
	public App() {
		this.executar();
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Executa os eventos da aplica��o.
	 */
	public void executar() {
		this.iniciar();
		this.atualizar();
		this.encerrar();
	}
	
	
}
