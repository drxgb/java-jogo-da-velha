/**
 * -------------------------------------------------- 
 * 				*** JOGO DA VELHA *** 
 * --------------------------------------------------
 * Classe Main
 * <p>Classe responsavel por rodar a aplicação</p>
 * 
 * @author Dr.XGB
 * @version 1.1
 * @see https://github.com/drxgb/java-jogo-da-velha.git
 */

package com.drxgb.consolegame.app;

import java.util.Scanner;

import com.drxgb.consolegame.gui.console.GUI;
import com.drxgb.consolegame.gui.console.JogoDaVelhaGUI;
import com.drxgb.consolegame.gui.console.TabuleiroGUI;
import com.drxgb.consolegame.gui.console.VisualGUI;
import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.JogoException;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.PosicaoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.Tabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.JogadorJogoDaVelha;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.JogoDaVelha;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.Marca;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.TabuleiroJogoDaVelha;

public class Main {

	public static void main(String[] args) {
		
		// Configurações iniciais
		Scanner sc = new Scanner(System.in);
		Jogo jogo = new JogoDaVelha();
		GUI gui = new JogoDaVelhaGUI(jogo, '|', '-', null);
		
		gui.limpaTela();
		gui.titulo();
		
		// Registrar Jogadores
		jogo.registraJogador(new JogadorJogoDaVelha(gui.insereNome(sc), false, Marca.O));	 // Jogador
		jogo.registraJogador(new JogadorJogoDaVelha(Marca.X));								// IA		
		
		// Quantidade de casas
		((JogoTabuleiro) jogo).setTabuleiro(new TabuleiroJogoDaVelha(((JogoDaVelhaGUI) gui).insereCasas(sc)));
		
		// Iniciar partida
		gui.limpaTela();
		gui.titulo();
		gui.iniciar();
		
		// Loop principal
		while(!jogo.isEncerrado()) {
			
			try {				
				
				// Vez dos jogadores
				for(int vez = 0; vez < jogo.getJogadores().size(); vez++) {
					// Atualiza a tela
					atualizaTela(gui);
					gui.escreveTurno();
					
					// Marcar no tabuleiro
					JogadorJogoDaVelha jogador = (JogadorJogoDaVelha) ((JogoTabuleiro) jogo).getVez();
					if(jogador.isIA()) {
						// IA
						gui.pause(1);
						jogador.agir(jogo);
					} else {
						// Jogador humano
						jogador.marcar(
								(PosicaoTabuleiro) ((VisualGUI) gui).escolhePosicao(sc),
								((JogoTabuleiro) jogo).getTabuleiro()
							);
					}
					
					// Analisar se a partida acabou
					if(((JogoTabuleiro) jogo).jogadaFinal()) {
						jogo.setEncerrado(true);
						break;
					}
					
					// Passa para o próximo jogador
					((JogoTabuleiro) jogo).trocaVez();
				}
				
				// Troca de Turno
				if(!jogo.isEncerrado())	jogo.proximoTurno();
				
			} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
				
				// *** ERRO *** : Usuário digitou valor inválido 
				Tabuleiro tabuleiro = ((JogoTabuleiro) jogo).getTabuleiro();
				char maxColuna = (char) (tabuleiro.getComprimento() - 1);
				maxColuna += 'A';
				StringBuilder sb = new StringBuilder();
				sb.append("Valor inválido: ");
				sb.append("A casa deve ser de A0 até ");				
				sb.append(maxColuna);
				sb.append(tabuleiro.getLargura() - 1);
				gui.escreveErro(sb.toString());
			} catch(JogoException e) {
				gui.escreveErro(e.getMessage());
			}
		}		
		
		// Resultado final
		atualizaTela(gui);
		gui.resultadoFinal();
		System.out.println("\n=======================================\n");
		
		// Fim de jogo		
		gui.fim();
		sc.close();
		gui.limpaTela();
		
	}
	
	/**
	 * Apaga todo o conteúdo da tela e
	 * reinsere a interface do jogo. 
	 * @param gui -> interface gráfica
	 */
	private static void atualizaTela(GUI gui) {
		gui.limpaTela();
		gui.titulo();
		((TabuleiroGUI) gui).desenhaTabuleiro();
	}

}
