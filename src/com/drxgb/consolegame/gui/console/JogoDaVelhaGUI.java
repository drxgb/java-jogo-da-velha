/**
 * Classe JogoDaVelhaGUI
 * <p>Responsável por controlar a interface
 * gráfica de um Jogo da Velha</p>
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
	 * Instancia uma nova interface gráfica para
	 * um Jogo da Velha.
	 * @param jogo -> instância de <code>Jogo</code>
	 */
	public JogoDaVelhaGUI(Jogo jogo) {
		this(jogo, null, null, null);
	}
	
	/**
	 * Instancia uma nova interface gráfica visual
	 * @param jogo -> instância de <code>Jogo</code>
	 * @param separadorColuna -> caractere definido para ser o separador das colunas
	 * @param separadorLinha -> caractere definido para ser o separador das linhas
	 * @param espacoVazio -> caractere definido para ser o espaço vazio
	 * @param borda -> a interface terá uma borda ou não?
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
	 * 				*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mostra uma tela onde será definida a quantidade de
	 * casas compostas pelo tabuleiro.
	 * @param sc -> instância de <code>Scanner</code> para
	 * receber a entrada de um valor
	 * @return a quantidade de casas determinada pelo usuário.
	 */
	public int insereCasas(Scanner sc) {
		int casas = 3;
		boolean validado = false;
		
		do {
			
			try {
				
				this.limpaTela();
				this.titulo();
				System.out.print("Digite o tamanho do tabuleiro (número de 3 a 7) => ");
				casas = sc.nextInt();
				if(casas < 3 || casas > 7) {
					throw new TabuleiroException("ERRO:\tO valor digitado não é um número de 3 até 7.");
				}
				validado = true;
				
			} catch(TabuleiroException e) {				
				System.err.println(e.getMessage() + "\n");
				this.pause(3);				
			} catch(InputMismatchException e) {				
				System.err.println("ERRO:\tO valor digitado não é um número.\n");
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
		System.out.println("É a vez de " + ((JogoTabuleiro) this.jogo).getVez().getNome());
		System.out.println();
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
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
