/**
 * Classe Console
 * <p>Responsável por controlar as ações de
 * uma aplicação Java em um console.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see App
 * @see EventosConsole
 */

package com.drxgb.consolegame.app.console;

import java.util.Scanner;

import com.drxgb.consolegame.app.App;
import com.drxgb.consolegame.gui.console.GUI;
import com.drxgb.consolegame.jogo.Jogo;

public abstract class Console extends App implements EventosConsole {

	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Scanner sc;
	protected GUI gui;
	protected Jogo jogo;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Console() {
		super();
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	@Override
	public void iniciar() {
		this.sc = new Scanner(System.in);
	}
	
	@Override
	public void encerrar() {
		sc.close();
	}
	
}
