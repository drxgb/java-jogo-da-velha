/**
 * Interface EventosConsole
 * <p>Contrato que implementa a��es de uma
 * aplica��o console.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * 
 */

package com.drxgb.consolegame.app.console;

public interface EventosConsole {
	
	/**
	 * Apaga todo o conte�do da tela e
	 * reinsere a interface do jogo. 
	 */
	void atualizaTela();
	
	/**
	 * Registra os jogadores que participar�o
	 * do jogo.
	 */
	void registraJogadores();
	
	/**
	 * Inicializa o jogo.
	 */
	void iniciaJogo();
	
	/**
	 * Loop Principal do jogo.
	 */
	void loop();
	
	/**
	 * Mostra o resultado final do jogo antes de
	 * ser, de fato, encerrado.
	 */
	void resultadoFinal();

}
