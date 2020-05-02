/**
 * Classe ConsoleJogoDaVelha
 * <p>Classe responsável por controlar a aplicação
 * do Jogo Da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.2
 * @see ConsoleTabuleiro
 * @see https://github.com/drxgb/java-jogo-da-velha.git
 */

package com.drxgb.consolegame.app.console;

import com.drxgb.consolegame.gui.console.JogoDaVelhaGUI;
import com.drxgb.consolegame.gui.console.TabuleiroGUI;
import com.drxgb.consolegame.gui.console.VisualGUI;
import com.drxgb.consolegame.jogo.JogoException;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.PosicaoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.Tabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.JogadorJogoDaVelha;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.JogoDaVelha;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.Marca;
import com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha.TabuleiroJogoDaVelha;

public class ConsoleJogoDaVelha extends ConsoleTabuleiro {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia uma nova aplicação do Jogo Da Velha.
	 */
	public ConsoleJogoDaVelha() {
		super();
	}

	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public void iniciar() {
		super.iniciar();
		this.jogo = new JogoDaVelha();
		this.gui = new JogoDaVelhaGUI(jogo, '|', '-', null);
		gui.limpaTela();
		gui.titulo();
	}

	@Override
	public void atualizar() {
		this.registraJogadores();
		this.registraTabuleiro();
		this.iniciaJogo();
		this.loop();
		this.resultadoFinal();
	}
	
	@Override
	public void encerrar() {
		super.encerrar();
		gui.fim();
		gui.limpaTela();
	}

	@Override
	public void atualizaTela() {
		gui.limpaTela();
		gui.titulo();
		((TabuleiroGUI) gui).desenhaTabuleiro();		
	}

	@Override
	public void registraJogadores() {
		jogo.registraJogador(new JogadorJogoDaVelha(gui.insereNome(sc), false, Marca.O));	 // Jogador
		jogo.registraJogador(new JogadorJogoDaVelha(Marca.X));		
	}

	@Override
	public void iniciaJogo() {
		gui.limpaTela();
		gui.titulo();
		gui.iniciar();		
	}

	@Override
	public void loop() {
while(!jogo.isEncerrado()) {
			
			try {				
				
				// Vez dos jogadores
				for(int vez = 0; vez < jogo.getJogadores().size(); vez++) {
					// Atualiza a tela
					this.atualizaTela();
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
	}

	@Override
	public void resultadoFinal() {
		this.atualizaTela();
		gui.resultadoFinal();
		System.out.println("\n=======================================\n");		
	}

	@Override
	public void registraTabuleiro() {
		((JogoTabuleiro) jogo).setTabuleiro(
				new TabuleiroJogoDaVelha(
						((JogoDaVelhaGUI) gui).insereCasas(sc)
					)
			);		
	}

}
