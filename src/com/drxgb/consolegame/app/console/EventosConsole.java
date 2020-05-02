/**
 * Interface EventosConsole
 * <p>Contrato que implementa ações de uma
 * aplicação console.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * 
 */

package com.drxgb.consolegame.app.console;

public interface EventosConsole {
	
	/**
	 * Apaga todo o conteúdo da tela e
	 * reinsere a interface do jogo. 
	 */
	void atualizaTela();
	
	/**
	 * Registra os jogadores que participarão
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
