/**
 * Classe JogoDaVelhaIA
 * <p>Responsável por controlar a IA de
 * um Jogo da Velha</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see TabuleiroIA
 * @see IA
 */

package com.drxgb.consolegame.jogo.visual.tabuleiro.jogodavelha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.drxgb.consolegame.jogo.Jogador;
import com.drxgb.consolegame.jogo.Jogo;
import com.drxgb.consolegame.jogo.visual.tabuleiro.JogoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.PosicaoTabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.Tabuleiro;
import com.drxgb.consolegame.jogo.visual.tabuleiro.TabuleiroIA;

public class JogoDaVelhaIA extends TabuleiroIA {
	
	/*
	 * ===========================================================
	 * 				*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private static final Random RANDOM = new Random();
	
	/*
	 * ===========================================================
	 * 				*** CONSTRUTORES ***
	 * ===========================================================
	 */	

	/**
	 * Instancia uma IA para o Jogo Da Velha
	 * @param jogo -> instância do <code>Jogo</code>
	 * @param jogador -> instância de <code>Jogador</code>
	 */
	public JogoDaVelhaIA(Jogo jogo, Jogador jogador) {
		super(jogo, jogador);
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica a possibilidade da IA realizar a última jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * será retornada uma instância de <code>Posicao</code>.
	 * Se a IA ainda não tem como vencer a partida, será
	 * retornado o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private PosicaoTabuleiro jogadaFinal() {
		Set<PosicaoTabuleiro> posicoesAlvo = new HashSet<>();
		posicoesAlvo.add(this.verificaHorizontal((JogadorJogoDaVelha) this.jogador));
		posicoesAlvo.add(this.verificaVertical((JogadorJogoDaVelha) this.jogador));
		posicoesAlvo.add(this.verificaDiagonal((JogadorJogoDaVelha) this.jogador));
		for(PosicaoTabuleiro alvo : posicoesAlvo) {
			if(alvo != null)
				return alvo;
		}		
		return null;
	}
	
	/**
	 * Verifica a possibilidade do Oponente realizar a última jogada
	 * para vencer a partida. Caso haja essa possibilidade,
	 * será retornada uma instância de <code>Posicao</code>.
	 * Se o oponente ainda não tem como vencer a partida, será
	 * retornado o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private PosicaoTabuleiro jogadaFinalOponente() {
		Set<Jogador> oponentes = new HashSet<>();
		oponentes = this.jogo.getJogadores().stream()
				.filter(x -> !x.equals(this.jogador))
				.collect(Collectors.toSet());
		for(Jogador op : oponentes) {
			JogadorJogoDaVelha oponente = (JogadorJogoDaVelha) op;
			Set<PosicaoTabuleiro> posicoesAlvo = new HashSet<>();
			posicoesAlvo.add(this.verificaHorizontal(oponente));
			posicoesAlvo.add(this.verificaVertical(oponente));
			posicoesAlvo.add(this.verificaDiagonal(oponente));
			for(PosicaoTabuleiro alvo : posicoesAlvo) {
				if(alvo != null)
					return alvo;
			}
		}		
		return null;
	}
	
	/**
	 * Verifica se a IA já marcou em algumas casa para
	 * poder marcar uma casa vizinha de sua marca.
	 * Se a sua marca for encontrada, será escolhida
	 * aleatoriamente uma <code>Posicao</code>. Se
	 * nenhuma marca da IA foi encontrada, será retornado
	 * o valor <code>null</code>.
	 * @return uma posição disponível para realizar a jogada
	 */
	private PosicaoTabuleiro buscaPosciaoMarcada() {
		Tabuleiro tabuleiro = ((JogoTabuleiro) jogo).getTabuleiro();
		Set<PosicaoTabuleiro> posicaoPecasIA = new HashSet<>();
		
		// Varrer todas as casas da IA no tabuleiro			
		for(int g = 0; g < (tabuleiro.getComprimento() * tabuleiro.getLargura()); g++) {
			int x = g % tabuleiro.getComprimento();
			int y = g / tabuleiro.getComprimento();
			PecaJogoDaVelha peca = (PecaJogoDaVelha) tabuleiro.getPeca(x, y);
			if(peca != null && peca.getMarca() == ((JogadorJogoDaVelha) this.jogador).getMarca()) {
				posicaoPecasIA.add(new PosicaoTabuleiro(peca, x, y));
			}
		}
		
		// Varrer por todas as posições para marcar uma casa vizinha
		for(PosicaoTabuleiro posicao : posicaoPecasIA) {
			
			// Gerar posições possíveis para checar as casas
			List<PosicaoTabuleiro> posicoesPossiveis = new ArrayList<>();
			for(int x = (posicao.getX() - 1); x < (posicao.getX() + 1); x++) {
				for(int y = (posicao.getY() - 1); y < (posicao.getY() + 1); y++) {
					if(tabuleiro.posicaoExiste(x, y)) {
						
						// Incluir somente casas vazias do tabuleiro
						if(!tabuleiro.temPeca(x, y)) {
							posicoesPossiveis.add(new PosicaoTabuleiro(x, y));
						}
						
					}
				}
			}
			
			// Sortear uma casa vizinha para marcar
			int tam = posicoesPossiveis.size();
			if(tam > 0) {
				int r = RANDOM.nextInt(tam);
				return posicoesPossiveis.get(r);
			}	
			
		}				
		
		// Retorne nulo se não existir nenhuma possbilidade de marcação vizinha
		return null;
	}
	
	/**
	 * A IA escolherá uma casa aleatoriamente e retornará
	 * uma <code>Posicao</code> para ser marcada.
	 * @return uma posição disponível para realizar a jogada
	 */
	private PosicaoTabuleiro escolheQualquerCasa() {
		PosicaoTabuleiro posicaoAlvo = null;
		
		// Sortear um número da posição da grade do tabuleiro
		while(posicaoAlvo == null) {
			Tabuleiro tabuleiro = ((JogoTabuleiro) this.jogo).getTabuleiro();
			int grade = RANDOM.nextInt(tabuleiro.getComprimento() * tabuleiro.getLargura());
			int x = grade % tabuleiro.getComprimento();
			int y = grade / tabuleiro.getComprimento();
			if(!tabuleiro.temPeca(x, y)) {
				posicaoAlvo = new PosicaoTabuleiro(x, y);
			}
		}
		
		// Retornar a posição disponível		
		return posicaoAlvo;
	}
	
	/**
	 * Verifica se há alguma linha que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private PosicaoTabuleiro verificaHorizontal(JogadorJogoDaVelha jogador) {
		Tabuleiro tabuleiro = ((JogoTabuleiro) this.jogo).getTabuleiro();
		List<PosicaoTabuleiro> posicoes = new ArrayList<>();		
		
		// Varrer por todas as linhas do tabuleiro
		for(int linha = 0; linha < tabuleiro.getLargura(); linha++) {
			posicoes.clear();
			
			// Coletar posições das peças da linha
			for(int coluna = 0; coluna < tabuleiro.getComprimento(); coluna++) {
				PecaJogoDaVelha peca = (PecaJogoDaVelha) tabuleiro.getPeca(coluna, linha);
				posicoes.add(new PosicaoTabuleiro(peca, coluna, linha));
			}
			
			// Separar posições dos jogadores das vazias
			PosicaoTabuleiro posicaoVazia = this.comparaPecas(posicoes, jogador);
			if(posicaoVazia != null)
				return posicaoVazia;			
		}
		
		// Se não encontrou nada, retorne nulo
		return null;
	}
	
	/**
	 * Verifica se há alguma coluna que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private PosicaoTabuleiro verificaVertical(JogadorJogoDaVelha jogador) {
		Tabuleiro tabuleiro = ((JogoTabuleiro) this.jogo).getTabuleiro();
		List<PosicaoTabuleiro> posicoes = new ArrayList<>();		
		
		// Varrer por todas as linhas do tabuleiro
		for(int coluna = 0; coluna < tabuleiro.getComprimento(); coluna++) {
			posicoes.clear();
			
			// Coletar posições das peças da linha
			for(int linha = 0; linha < tabuleiro.getLargura(); linha++) {
				PecaJogoDaVelha peca = (PecaJogoDaVelha) tabuleiro.getPeca(coluna, linha);
				posicoes.add(new PosicaoTabuleiro(peca, coluna, linha));
			}
			
			// Separar posições dos jogadores das vazias
			PosicaoTabuleiro posicaoVazia = this.comparaPecas(posicoes, jogador);
			if(posicaoVazia != null)
				return posicaoVazia;			
		}
		
		// Se não encontrou nada, retorne nulo
		return null;
	}
	
	/**
	 * Verifica se há alguma diagonal que está prestes a
	 * ter uma jogada final a ser realizada.
	 * Caso seja encontrada, retornará uma <code>Posicao</code>
	 * para ser marcada. Se não encontrar nenhuma casa ameaçada,
	 * retornará <code>null</code>.
	 * @param jogador -> instância de <code>JogadorJogoDaVelha</code>
	 * @return uma posição possível para uma jogada final
	 */
	private PosicaoTabuleiro verificaDiagonal(JogadorJogoDaVelha jogador) {
		Tabuleiro tabuleiro = ((JogoTabuleiro) this.jogo).getTabuleiro();
		List<PosicaoTabuleiro> posicoes = new ArrayList<>();
			
		// Diagonal Principal
		for(int d = 0; d < tabuleiro.getComprimento(); d++) {
			PecaJogoDaVelha peca = (PecaJogoDaVelha) tabuleiro.getPeca(d);
			posicoes.add(new PosicaoTabuleiro(peca, d));
		}	
		
		PosicaoTabuleiro posicaoVazia = this.comparaPecas(posicoes, jogador);
		if(posicaoVazia != null)
			return posicaoVazia;
		
		// Diagonal Principal Reversa
		posicoes.clear();
		int x = tabuleiro.getComprimento() - 1;
		for(int y = 0; y < tabuleiro.getLargura(); y++) {
			PecaJogoDaVelha peca = (PecaJogoDaVelha) tabuleiro.getPeca(x, y);
			posicoes.add(new PosicaoTabuleiro(peca, x--, y));
		}
		
		posicaoVazia = this.comparaPecas(posicoes, jogador);
		if(posicaoVazia != null)
			return posicaoVazia;
		
		// Se não encontrou nada, retorne nulo
		return null;
	}
	
	/**
	 * Verificação de um conjunto de peças, cujo este deve ter
	 * somente um dos espaços vazios para que a IA possa
	 * confirmar sua jogada final.
	 * @param posicoes -> conjunto de posições
	 * @param jogador -> instância de <code>Jogador</code>
	 * @return uma posição com espaço vazio e as outras casas
	 * do mesmo jogador. Se não atender os requisitos,
	 * retorna um valor <code>null</code>
	 */
	private PosicaoTabuleiro comparaPecas(List<PosicaoTabuleiro> posicoes, JogadorJogoDaVelha jogador) {
		Predicate<PosicaoTabuleiro> pred = x -> {
			PecaJogoDaVelha peca = (PecaJogoDaVelha) x.getPeca();
			return peca != null && peca.getMarca() == jogador.getMarca();
		};			
		Tabuleiro tabuleiro = ((JogoTabuleiro) this.jogo).getTabuleiro();
		
		Set<PosicaoTabuleiro> posicoesJogador = posicoes.stream()
				.filter(pred).
				collect(Collectors.toSet());
		List<PosicaoTabuleiro> posicoesVazias = posicoes.stream()
				.filter(x -> x.getPeca() == null)
				.collect(Collectors.toList());
		
		// Verificar se o oponente está fechando a horizontal
		if(
			posicoesVazias.size() == 1 &&
			posicoesJogador.size() == (tabuleiro.getComprimento() - 1)
		) {
			return posicoesVazias.get(0);
		}
		return null;
	}
	
	/*
	 * ===========================================================
	 * 				*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public PosicaoTabuleiro analisaTabuleiro() {
		List<PosicaoTabuleiro> posicoesAlvo = new ArrayList<>();
		
		posicoesAlvo.add(this.jogadaFinal());			// Verifica jogada IA
		posicoesAlvo.add(this.jogadaFinalOponente());	// Verifica jogada Oponente
		posicoesAlvo.add(this.buscaPosciaoMarcada());	// Buscar posição marcada
		
		// Retornar a posição possível caso tenha
		for(PosicaoTabuleiro alvo : posicoesAlvo) {
			if(alvo != null)
				return alvo;
		}
		
		// Se não tiver alguma posição disponível, marcar qualquer casa disponível
		return this.escolheQualquerCasa();
		
	}
	
}
