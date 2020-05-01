/**
 * Classe TabuleiroGUI
 * <p>Responsável poelas ações de interface gráfica de
 * usuário para jogos de tabuleiro.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see VisualGUI
 * @see GUI
 */

package com.drxgb.consolegame.gui.console;

import java.util.Scanner;

import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.visual.Posicao;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.Peca;
import com.drxgb.consolegame.jogo.visual.tabuleiro.PosicaoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.TabuleiroException;

public abstract class TabuleiroGUI extends VisualGUI {
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Instancia uma nova interface gráfica para um tabuleiro.
	 * @param jogo -> instância de <code>Jogo</code>
	 */
	public TabuleiroGUI(Jogo jogo) {
		this(jogo, null, null, null);
	}
	
	/**
	 * <i>@{Sobrecarga}</i>
	 * Instancia uma nova interface gráfica para um tabuleiro.
	 * @param jogo -> instância de <code>Jogo</code>
	 * @param separadorColuna -> caractere definido para ser o separador das colunas
	 * @param separadorLinha -> caractere definido para ser o separador das linhas
	 * @param espacoVazio -> caractere definido para ser o espaço vazio
	 * @param borda -> a interface terá uma borda ou não?
	 */
	public TabuleiroGUI(
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
	 * Desenha o tabuleiro na tela do jogo.
	 */
	public void desenhaTabuleiro() {
		if(this.separadorColuna == null) this.separadorColuna = ' ';
		if(this.espacoVazio == null) this.espacoVazio = ' ';
		this.desenhaColunas();
		this.desenhaLinhas();
		System.out.println();
	}	
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */	
	
	@Override
	public Posicao escolhePosicao(Scanner sc) {
		PosicaoTabuleiro posicao = null;
		
		while(posicao == null) {
			
			try {
				// Insere a entrada
				System.out.print("Escolha uma posição => ");
				String input = sc.nextLine();
				
				// Pega posições de acordo com o valor de entrada
				int coluna = input.charAt(0) - 'A';
				int linha = Integer.parseInt(input.substring(1, 2));
				
				// Instancia uma posição
				posicao = new PosicaoTabuleiro(coluna, linha);			
				if(!((JogoTabuleiro) jogo).temEspacoVazio(posicao)) {
					posicao = null;
					throw new TabuleiroException("\nEsta casa já está preenchida.");
				}
			} catch(TabuleiroException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return (Posicao) posicao;
	}

	@Override
	protected void desenhaColunas(boolean borda) {
		int tam = ((JogoTabuleiro) this.jogo).getTabuleiro().getComprimento();
		
		// Legendas das Colunas
		System.out.print("\t\t" + "  ");
		System.out.print((borda) ? this.separadorColuna : " ");
		for(int i = 0; i < tam; i++) {
			char c = 'A';
			c += (char) i;
			System.out.print(c);
			System.out.print((borda) ? this.separadorColuna : " ");
		}
		
		// Fim da Coluna
		System.out.println();
	}
	
	@Override
	protected void desenhaLinhas(boolean borda) {
		
		// Borda superior
		if(borda) this.desenhaLinhaSeparadora(false);
		
		// Linha
		int[] tam = {
				((JogoTabuleiro) this.jogo).getTabuleiro().getComprimento(),
				((JogoTabuleiro) this.jogo).getTabuleiro().getLargura()
		};
		for(int linha = 0; linha < tam[1]; linha++) {
			
			// Legenda			
			System.out.print("\t\t" + linha + " ");
			System.out.print((borda) ? this.separadorColuna : " ");
			
			// Escrevendo as colunas
			Peca[][] pecas = ((JogoTabuleiro) this.jogo).getTabuleiro().getPecas();
			for(int coluna = 0; coluna < tam[0]; coluna++) {
				if(pecas[coluna][linha] != null) {
					System.out.print(pecas[coluna][linha].get());
				} else {
					System.out.print(this.espacoVazio);
				}
				if((coluna < (tam[0] - 1)) || borda)
					System.out.print(this.separadorColuna);
			}			
			
			// Fim da linha
			System.out.println();
			if(linha < (tam[1] - 1)) {
				this.desenhaLinhaSeparadora(borda);
			}
		}
		
		// Borda inferior
		if(borda) this.desenhaLinhaSeparadora(false);
	}
	
	@Override
	protected void desenhaLinhaSeparadora(boolean borda) {
		if(this.separadorLinha == null) return;
		
		int len = ((JogoTabuleiro) this.jogo).getTabuleiro().getComprimento() * 2;
		
		System.out.print("\t\t" + "  ");		
		for(int l = 0; l <= len; l++) {
			if(borda && (l == 0 || l == len)) {
				System.out.print(this.separadorColuna);
			} else if(!borda && (l == 0 || l == len)) {
				System.out.print(" ");
			} else {
				System.out.print(this.separadorLinha);
			}
		}
		System.out.println();
	}
	
}
