/**
 * Classe GUI
 * <p>Responsável pela interface gráfica geral do jogo</p>
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
	 * Instancia uma nova interface gráfica.
	 * @param jogo -> instância de <code>Jogo</code>
	 */
	public GUI(Jogo jogo) {
		this.jogo = jogo;
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */

	/**
	 * Apaga todo o conteúdo da tela. Normalmente utilizado para
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
	 * Mostra a tela de inserção de nome.
	 * @param sc -> instância de <code>Scanner</code> para realizar
	 * a entrada do nome
	 * @return um novo nome
	 */
	public String insereNome(Scanner sc) {
		System.out.print("Insira o seu nome => ");
		String nome = sc.nextLine();
		System.out.println("Olá, " + nome + "!");
		this.pause(1);
		return nome;
	}
	
	/**
	 * Mostra uma mensagem de inicialiação do jogo.
	 */
	public void iniciar() {
		System.out.println("O jogo está sendo iniciado...");
		this.pause(3);
		System.out.println("Pronto!");
		this.pause(1);
		jogo.iniciaTempo();
	}
	
	/**
	 * Escreve a tela de título do jogo.
	 * @param jogo -> instância de <code>Jogo</code>
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
	 * Escreve um relatório do tempo decorrido de jogo.
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
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra o resultado final do jogo e suas estatísticas.
	 * @param jogo -> instância de <code>Jogo</code>
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
