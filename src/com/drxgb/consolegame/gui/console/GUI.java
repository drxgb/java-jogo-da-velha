/**
 * Classe GUI
 * <p>Respons�vel pela interface gr�fica geral do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.gui.console;

import java.io.IOException;
import java.util.Scanner;

import com.drxgb.consolegame.jogo.Jogo;

public abstract class GUI {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Jogo jogo;
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova interface gr�fica.
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 */
	public GUI(Jogo jogo) {
		this.jogo = jogo;
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */

	/**
	 * Apaga todo o conte�do da tela. Normalmente utilizado para
	 * atualizar a tela do jogo.
	 */
	public void limpaTela() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pausa o jogo por um tempo determinado.
	 * @param millis -> quantidade de milisegundos a serem pausados
	 */
	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <i>@Sobrecarga</i><br>
	 * Pausa o jogo por um tempo determinado.
	 * @param segundos -> quantidade de segundos a serem pausados
	 */
	public void pause(int segundos) {
		this.pause(((long) segundos) * 1000L);
	}
	
	/**
	 * Mostra a tela de inser��o de nome.
	 * @param sc -> inst�ncia de <code>Scanner</code> para realizar
	 * a entrada do nome
	 * @return um novo nome
	 */
	public String insereNome(Scanner sc) {
		System.out.print("Insira o seu nome => ");
		String nome = sc.nextLine();
		System.out.println("Ol�, " + nome + "!");
		this.pause(1);
		return nome;
	}
	
	/**
	 * Mostra uma mensagem de inicialia��o do jogo.
	 */
	public void iniciar() {
		System.out.println("O jogo est� sendo iniciado...");
		this.pause(3);
		System.out.println("Pronto!");
		this.pause(1);
		jogo.iniciaTempo();
	}
	
	/**
	 * Escreve a tela de t�tulo do jogo.
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 */
	public void titulo() {
		System.out.println("==================================================");
		System.out.print("\t\t");
		System.out.println(this.jogo.getNome().toUpperCase());
		System.out.println("==================================================");
		System.out.println();
	}
	
	/**
	 * Mostra o valor atual do turno do jogo.
	 */
	public void escreveTurno() {
		System.out.println("Turno: " + this.jogo.getTurnos());
	}
	
	/**
	 * Escreve uma mensagem de encerramento do jogo
	 * antes de fechar o prompt.
	 */
	public void fim() {
		System.out.println("Obrigado por jogar! =D");
		System.out.print((char) 0xA9); // Copyright Logo
		System.out.println("2020 - Desenvolvido por Dr.XGB");
		this.pause(5);
	}
	
	/**
	 * Escreve um relat�rio do tempo decorrido de jogo.
	 */
	public void escreveTempoDecorrido() {
		int horas = jogo.getTempo().getIntHoras();
		int minutos = jogo.getTempo().getIntMinutos();
		System.out.print("Tempo decorido: ");
		if(horas > 0) {
			System.out.print(horas + " ");
			System.out.print((horas > 1) ? "horas" : "hora");
			System.out.print(" ");
		}
		if(minutos > 0) {
			System.out.print(minutos + " ");
			System.out.print((minutos > 1) ? "segundos" : "minuto");
			System.out.print(" ");
		}

		double segundos = jogo.getTempo().getSegundos();
		if(minutos > 0) {
			segundos = (int) jogo.getTempo().getIntSegundos();
		}		
		System.out.print(segundos + " ");
		System.out.print((segundos > 1) ? "segundos" : "segundo");
		System.out.print("\n\n");
	}
	
	/**
	 * Escreve uma mensagem de erro na tela.
	 * @param msg -> a mensagem de erro
	 */
	public void escreveErro(String msg) {
		System.err.println(msg);
		this.pause(5);
	}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra o resultado final do jogo e suas estat�sticas.
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 */
	public abstract void resultadoFinal();

	/*
	 * ===========================================================
	 * 				*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public Jogo getJogo() {
		return jogo;
	}
	
}
