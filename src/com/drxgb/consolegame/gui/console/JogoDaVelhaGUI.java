/**
 * Classe JogoDaVelhaGUI
 * <p>Respons�vel por controlar a interface
 * gr�fica de um Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see TabuleiroGUI
 * @see GUI
 */

package com.drxgb.consolegame.gui.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.TabuleiroException;

public class JogoDaVelhaGUI extends TabuleiroGUI {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma nova interface gr�fica para
	 * um Jogo da Velha.
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 */
	public JogoDaVelhaGUI(Jogo jogo) {
		this(jogo, null, null, null);
	}
	
	/**
	 * Instancia uma nova interface gr�fica visual
	 * @param jogo -> inst�ncia de <code>Jogo</code>
	 * @param separadorColuna -> caractere definido para ser o separador das colunas
	 * @param separadorLinha -> caractere definido para ser o separador das linhas
	 * @param espacoVazio -> caractere definido para ser o espa�o vazio
	 * @param borda -> a interface ter� uma borda ou n�o?
	 */
	public JogoDaVelhaGUI(
			Jogo jogo,
			Character separadorColuna,
			Character separadorLinha,
			Character espacoVazio
	) {
		super(jogo, separadorColuna, separadorLinha, espacoVazio);
	}
	

	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra uma tela onde ser� definida a quantidade de
	 * casas compostas pelo tabuleiro.
	 * @param sc -> inst�ncia de <code>Scanner</code> para
	 * receber a entrada de um valor
	 * @return a quantidade de casas determinada pelo usu�rio.
	 */
	public int insereCasas(Scanner sc) {
		int casas = 3;
		boolean validado = false;
		
		do {
			
			try {
				
				this.limpaTela();
				this.titulo();
				System.out.print("Digite o tamanho do tabuleiro (n�mero de 3 a 7) => ");
				casas = sc.nextInt();
				if(casas < 3 || casas > 7) {
					throw new TabuleiroException("ERRO:\tO valor digitado n�o � um n�mero de 3 at� 7.");
				}
				validado = true;
				
			} catch(TabuleiroException e) {				
				System.err.println(e.getMessage() + "\n");
				this.pause(3);				
			} catch(InputMismatchException e) {				
				System.err.println("ERRO:\tO valor digitado n�o � um n�mero.\n");
				this.pause(3);				
			} finally {
				sc.nextLine();
			}
			
		} while(!validado);
		
		return casas;		
	}
	
	@Override
	public void escreveTurno() {
		super.escreveTurno();
		System.out.println("� a vez de " + ((JogoTabuleiro) this.jogo).getVez().getNome());
		System.out.println();
	}
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public void resultadoFinal() {
		System.out.println("FIM DE JOGO!");
		
		// Declarar vencedor (caso tenha)
		if(((JogoTabuleiro) jogo).getVencedor() != null) {
			System.out.print(((JogoTabuleiro) jogo).getVencedor().getNome());
			System.out.println(" ganhou!");
		} else {
			System.out.println("Partida empatada");
		}
		System.out.println();
		
		// Quantidade de Turnos
		System.out.print("A partida teve ");
		System.out.print(jogo.getTurnos());
		System.out.println(" turnos.\n");
		
		// Tempo decorrido
		this.escreveTempoDecorrido();
		
		this.pause(3);
		
	}
	
}
