/**
 * Interface Eventos
 * <p>Contrato que implementa ações de uma
 * aplicação.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.app;

public interface Eventos {

	/**
	 * Realiza ações de pré-configuração da aplicação.
	 */
	void iniciar();
	
	/**
	 * Atualiza o estado do jogo constantemente.
	 * Normalmente aplica-se um loop neste método
	 * e este laço será rompido quando atender
	 * algum requisito de encerramento de jogo.
	 */
	void atualizar();
	
	/**
	 * Realiza ações após o encerramento da aplicação.
	 */
	void encerrar();
	
}
